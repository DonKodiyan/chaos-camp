package ch.zuehlke.chaoscamp.app;

import ch.zuehlke.chaoscamp.app.resilience.CircuitBreakerRuntimeException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;

@Service
public class AppService {

    private  static final Logger LOGGER = LoggerFactory.getLogger(AppService.class);

    private final RestTemplate restTemplate;
    private final String baseUri;
    private final CircuitBreaker circuitBreaker;

    public AppService(@Value("${external.hasher.api}") String api) {
        this.restTemplate = new RestTemplate();
        this.baseUri = api;
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .ringBufferSizeInHalfOpenState(2)
                .ringBufferSizeInClosedState(5)
                .build();

        this.circuitBreaker = CircuitBreakerRegistry.of(circuitBreakerConfig).circuitBreaker("hasher");
    }

    @HystrixCommand(fallbackMethod = "getHashFallback")
    public String getHash(String value) {
        String uri = UriComponentsBuilder.newInstance().uri(URI.create(baseUri)).path("/hash").queryParam("value", value).build().toString();
        return restTemplate.getForObject(uri, String.class);
    }

    public String getHashResilient(String value) {
        String uri = UriComponentsBuilder.newInstance().uri(URI.create(baseUri)).path("/hash").queryParam("value", value).build().toString();

        Supplier<String> backendFunction = CircuitBreaker.decorateSupplier(circuitBreaker, () -> {
            LOGGER.info("Trying to call");
            return restTemplate.getForObject(uri, String.class);
        });

        LOGGER.info(circuitBreaker.getState().name());
        return Try.ofSupplier(backendFunction).getOrElse("Backend is currently not available");

//        return Try.ofSupplier(backendFunction).getOrElseThrow(t -> new CircuitBreakerRuntimeException("Backend is currently not available", t));
    }

    @SuppressWarnings("unused")
    public String getHashFallback(String value) {
        LOGGER.debug("Hystrix fallback for hash called");
        return "Hystrix fallback for hash";
    }

    @HystrixCommand(fallbackMethod = "getHashMemoryIntensiveFallback")
    public String getHashMemoryIntensive(String value) {
        String uri = UriComponentsBuilder.newInstance().uri(URI.create(baseUri)).path("/hash-from-memory").queryParam("value", value).build().toString();
        return restTemplate.getForObject(uri, String.class);
    }

    @SuppressWarnings("unused")
    public String getHashMemoryIntensiveFallback(String value) {
        LOGGER.debug("Hystrix fallback for hash memory intensive called");
        return "Hystrix fallback for hash memory intensive";
    }

    public String getInfo() {
        return "<br/> Node MY_NODE_NAME: " + System.getenv().get("MY_NODE_NAME") +
                "<br/> Node MY_POD_NAME: " + System.getenv().get("MY_POD_NAME") +
                "<br/> Node MY_POD_NAMESPACE: " + System.getenv().get("MY_POD_NAMESPACE") +
                "<br/> Node MY_POD_IP: " + System.getenv().get("MY_POD_IP") +
                "<br/> Node MY_POD_SERVICE_ACCOUNT: " + System.getenv().get("MY_POD_SERVICE_ACCOUNT");
    }

}

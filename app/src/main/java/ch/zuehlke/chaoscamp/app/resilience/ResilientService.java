package ch.zuehlke.chaoscamp.app.resilience;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.Duration;

@Service

public class ResilientService {

    private final RestTemplate restTemplateTightTimeout;
    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String apiToxicUrl;


    public ResilientService(@Value("${external.hasher.api}") String api,
                            @Value("${external.hasher.api.toxic}") String toxicApi,
                            RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateTightTimeout = restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(1000))
                .setReadTimeout(Duration.ofMillis(1000))
                .build();

        this.restTemplate = new RestTemplate();

        this.apiUrl = api;
        this.apiToxicUrl = toxicApi;
    }

    public String plain() {
        return this.getHash(restTemplateTightTimeout, true, true);
    }

    @CircuitBreaker(name = "backendA")
    public String circuitBreaker() {
        return this.getHash(restTemplateTightTimeout, true, false);
    }

    @Retry(name = "backendA")
    public String retry() {
        return this.getHash(restTemplateTightTimeout, false, true);
    }


    @Bulkhead(name = "backendA")
    public String bulkhead() {
        return this.getHash(restTemplate, false, true);
    }

    @RateLimiter(name = "backendA")
    public String ratelimiter() {
        return this.getHash(restTemplate, false, true);
    }

    @CircuitBreaker(name = "backendA")
    @Retry(name = "backendA")
    @Bulkhead(name = "backendA")
    @RateLimiter(name = "backendA")
    public String allTogether() {
        return this.getHash(restTemplate, false, true);
    }

    private String getHash(RestTemplate restTemplate, boolean limit, boolean toxic) {
        String value = RandomStringUtils.randomAlphabetic(10);
        String endpoint = limit ? "/hash-limited" : "/hash";
        String apiUrl = toxic ? this.apiToxicUrl : this.apiUrl;

        String url = UriComponentsBuilder.newInstance().uri(
                URI.create(apiUrl))
                .path(endpoint)
                .queryParam("value", value)
                .build()
                .toString();
        return restTemplate.getForObject(url, String.class);
    }

    public String hashPlain(boolean toxic, String endpoint) {
        return getHashWithTimeout(toxic, endpoint);
    }

    @CircuitBreaker(name = "hashCircuitBreaker")
    public String hashCircuitBreaker() {
        return getHashWithTimeout(false, "/hash-sleeping");
    }

    private String getHashWithTimeout(boolean toxic, String endpoint) {
        String value = RandomStringUtils.randomAlphabetic(10);
        String apiUrl = toxic ? this.apiToxicUrl : this.apiUrl;
        String url = UriComponentsBuilder.newInstance().uri(
                URI.create(apiUrl))
                .path(endpoint)
                .queryParam("value", value)
                .build()
                .toString();

        SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(2000);

        return new RestTemplate(httpRequestFactory).getForObject(url, String.class);
    }
}

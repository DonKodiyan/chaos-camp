package ch.zuehlke.chaoscamp.app;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class AppService {
    private final RestTemplate restTemplate;
    private final String baseUri;

    public AppService(@Value("${external.hasher.api}") String api) {
        this.restTemplate = new RestTemplate();
        this.baseUri = api;
    }

    @HystrixCommand(fallbackMethod = "getHashFallback")
    public String getHash(String value) {
        String uri = UriComponentsBuilder.newInstance().uri(URI.create(baseUri)).path("/hash").queryParam("value", value).build().toString();
        return restTemplate.getForObject(uri, String.class);
    }

    @SuppressWarnings("unused")
    public String getHashFallback(String value) {
        System.out.println("Hystrix fallback for hash called");
        return "Hystrix fallback for hash";
    }

    @HystrixCommand(fallbackMethod = "getHashMemoryIntensiveFallback")
    public String getHashMemoryIntensive(String value) {
        String uri = UriComponentsBuilder.newInstance().uri(URI.create(baseUri)).path("/hash-from-memory").queryParam("value", value).build().toString();
        return restTemplate.getForObject(uri, String.class);
    }

    @SuppressWarnings("unused")
    public String getHashMemoryIntensiveFallback(String value) {
        System.out.println("Hystrix fallback for hash memory intensive called");
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

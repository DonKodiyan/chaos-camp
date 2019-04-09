package ch.zuehlke.chaoscamp.app;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppService {
    private final RestTemplate restTemplate;
    private final String baseUri;

    public AppService(@Value("${external.hasher.api}") String api) {
        restTemplate = new RestTemplate();
        baseUri = api;
    }

    @HystrixCommand(fallbackMethod = "hash_fallback")
    public String hash_base(String value) {
        return restTemplate.getForObject(baseUri + "/hash?value=" + value, String.class);
    }

    @SuppressWarnings("unused")
    public String hash_fallback(String value) {
        System.out.println("Hystrix fallback for hash called");
        return "Hystrix fallback for hash";
    }
}

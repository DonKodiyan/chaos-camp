package ch.zuehlke.chaoscamp.app.resilience;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.Duration;

@Service

public class ResilientService {

    private final RestTemplate restTemplateTightTimeout;
    private final RestTemplate restTemplate;
    private final String baseUri;

    public ResilientService(@Value("${external.hasher.api}") String api, RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateTightTimeout = restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(1000))
                .setReadTimeout(Duration.ofMillis(1000))
                .build();

        this.restTemplate = new RestTemplate();

        this.baseUri = api;
    }

    public String plain() {
        return this.getHash(restTemplateTightTimeout, false);
    }

    @CircuitBreaker(name = "backendA")
    public String circuitBreaker() {
        return this.getHash(restTemplate, true);
    }

    @Retry(name = "backendA")
    public String retry() {
        return this.getHash(restTemplateTightTimeout, false);
    }

    private String getHash(RestTemplate restTemplate, boolean limit) {
        String value = RandomStringUtils.randomAlphabetic(10);
        String endpoint = limit ? "/hash-limited" : "/hash";
        String url = UriComponentsBuilder.newInstance().uri(
                URI.create(baseUri))
                .path(endpoint)
                .queryParam("value", value)
                .queryParam("limit", limit)
                .build()
                .toString();
        return restTemplate.getForObject(url, String.class);
    }

}

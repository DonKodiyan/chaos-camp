package ch.zuehlke.chaoscamp.app;

import io.micrometer.core.annotation.Timed;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class AppController {

    private  static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    private final WebClient webClient;

    public AppController(@Value("${external.hasher.api}") String api) {
        webClient = WebClient.builder()
                .baseUrl(api)
                .build();

    }

    @Timed(value = "api.hello")
    @GetMapping("api/hello")
    public Mono<String> hash(@RequestParam("value") String value) {
        LOGGER.info("called 'hash' with value={}", value);
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/hash").queryParam("value", value).build())
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .retrieve()
                .bodyToMono(Response.class)
                .map(Response::getResult);
    }

    @Timed(value = "api.info")
    @GetMapping("api/info")
    public Mono<String> info() {
        LOGGER.info("called 'info'");
        return Mono.just(
                "<br/> Node MY_NODE_NAME: " + System.getenv().get("MY_NODE_NAME") +
                        "<br/> Node MY_POD_NAME: " + System.getenv().get("MY_POD_NAME") +
                        "<br/> Node MY_POD_NAMESPACE: " + System.getenv().get("MY_POD_NAMESPACE") +
                        "<br/> Node MY_POD_IP: " + System.getenv().get("MY_POD_IP") +
                        "<br/> Node MY_POD_SERVICE_ACCOUNT: " + System.getenv().get("MY_POD_SERVICE_ACCOUNT")
        );
    }

    @Timed(value = "api.cpu-intensive")
    @GetMapping("api/cpu-intensive")
    public Mono<String> getCpuIntensiveTask() {
        LOGGER.info("called 'getCpuIntensiveTask'");

        String value = RandomStringUtils.randomAlphabetic(10);

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/hash").queryParam("value", value).build())
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .retrieve()
                .bodyToMono(Response.class)
                .map(Response::getResult);
    }

    @Timed(value = "api.memory-intensive")
    @GetMapping("api/memory-intensive")
    public Mono<String> getMemoryIntensiveTask() {
        LOGGER.info("called 'getMemoryIntensiveTask'");
        String value = RandomStringUtils.randomAlphabetic(10);

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/hash-from-memory").queryParam("value", value).build())
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .retrieve()
                .bodyToMono(Response.class)
                .map(Response::getResult);
    }

    public static class Response {

        private String result;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}

package ch.zuehlke.chaoscamp.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class AppController {

  private final WebClient webClient;

  public AppController(@Value("${external.hasher.api}") String api) {
    webClient = WebClient.create(api);

  }

  @GetMapping("api/hello")
  public Mono<String> hash(@RequestParam("value") String value) {
    return webClient
            .get()
            .uri(uriBuilder -> uriBuilder.queryParam("value", value).build())
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .retrieve()
            .bodyToMono(Response.class)
            .map(Response::getResult);
  }

  @GetMapping("api/ping")
  public Mono<String> ping(@RequestParam("value") String value) {
    return Mono.just(value);
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

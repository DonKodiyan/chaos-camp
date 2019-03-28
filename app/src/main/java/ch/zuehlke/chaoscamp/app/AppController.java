package ch.zuehlke.chaoscamp.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppController {

  @Value("${external.hasher.api}")
  private String api;

  @GetMapping("api/hello")
  public String hash(@RequestParam("value") String value) {
    return new RestTemplate()
        .getForObject(api + "?value=" + value, Response.class).getResult();
  }

  @GetMapping("")
  public String test() {
    return "hello world";
  }

  public static class Response{
    private String result;

    public String getResult() {
      return result;
    }

    public void setResult(String result) {
      this.result = result;
    }
  }
}

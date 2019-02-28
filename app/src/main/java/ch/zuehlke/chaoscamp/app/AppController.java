package ch.zuehlke.chaoscamp.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppController {

  @GetMapping("api/hello")
  public String hash(@RequestParam("value") String value)  {
    return new RestTemplate()
        .getForObject("http://localhost:8082/api/hash?value=" + value, String.class);
  }

}

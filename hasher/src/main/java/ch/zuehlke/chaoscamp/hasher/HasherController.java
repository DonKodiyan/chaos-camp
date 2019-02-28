package ch.zuehlke.chaoscamp.hasher;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HasherController {

  @GetMapping("api/hash")
  public String hash(@RequestParam("value") String value) throws InterruptedException {
    Thread.sleep(1000L);
    return value;
  }

}

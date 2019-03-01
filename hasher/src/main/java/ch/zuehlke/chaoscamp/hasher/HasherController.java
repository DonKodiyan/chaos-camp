package ch.zuehlke.chaoscamp.hasher;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HasherController {

  @GetMapping("api/hash")
  public Response hash(@RequestParam("value") String value) {
    return new Response(BCrypt.hashpw(value, BCrypt.gensalt(10)));
  }

  public static class Response{
    private String result;

    public Response(String result) {
      this.result = result;
    }

    public String getResult() {
      return result;
    }
  }

}
package ch.zuehlke.chaoscamp.hasher;

import org.apache.commons.lang3.RandomStringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@RestController
public class HasherController {

    private  static final Logger LOGGER = LoggerFactory.getLogger(HasherController.class);

    private HashMap<String, String> inMemoryValues = new HashMap<>();
    private HashMap<String, String> wasteOfMemory = new HashMap<>();

    /**
     * Calculates the hash for a provided value. CPU-intensive
     *
     * @param value
     * @return
     */
    @GetMapping("api/hash")
    public Mono<Response> hashCpu(@RequestParam("value") String value) {
        LOGGER.debug("called 'hashCpu' with value={}", value);
        return Mono.just(new Response(hash(value)));
    }

    /**
     * Calculates or gets the hash from a in-memory cache. Memory-intensive
     *
     * @param value
     * @return
     */
    @GetMapping("api/hash-from-memory")
    public Mono<Response> hashFromMemory(@RequestParam("value") String value) {
        LOGGER.debug("called 'hashFromMemory' with value={}", value);
        if (!inMemoryValues.containsKey(value)) {
            inMemoryValues.put(value, hash(value));
        }

        // just waste some memory
        wasteOfMemory.put(value, RandomStringUtils.randomAlphabetic(10000));

        return Mono.just(new Response(inMemoryValues.get(value)));
    }


    private String hash(String value) {
        return BCrypt.hashpw(value, BCrypt.gensalt(10));
    }

    public static class Response {

        private String result;

        public Response(String result) {
            this.result = result;
        }

        public String getResult() {
            return result;
        }
    }

}

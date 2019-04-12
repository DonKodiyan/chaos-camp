package ch.zuehlke.chaoscamp.hasher;

import org.apache.commons.lang3.RandomStringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HasherController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HasherController.class);

    private static final HashMap<String, String> inMemoryValues = new HashMap<>();
    private static final HashMap<String, String> wasteOfMemory = new HashMap<>();
    private static final Integer MAX_CONCURRENT_USERS = 3;
    private static Semaphore concurrentAccessSemaphore;
    private static final AtomicInteger count = new AtomicInteger(0);

    public HasherController() {
        concurrentAccessSemaphore = new Semaphore(MAX_CONCURRENT_USERS);
    }


    @GetMapping("api/hash-fading")
    public Mono<Response> hashFading(@RequestParam("value") String value) {
        int connectionCount = count.incrementAndGet();
        Mono<Response> hash = Mono.just(new Response(hash(value, 10 + connectionCount)));
        count.decrementAndGet();

        return hash;
    }

    @GetMapping("api/hash-sleeping")
    public Mono<Response> hashSleeping(@RequestParam("value") String value) throws InterruptedException {
        int connectionCount = count.incrementAndGet();
        int timeoutValue = 1000 + connectionCount * 200;
        LOGGER.info("Sleeping for " + timeoutValue);
        try {
            Thread.sleep(timeoutValue);
        } finally {
            count.decrementAndGet();
        }


        return Mono.just(new Response("dummy-hash"));
    }

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

    @GetMapping("api/hash-limited")
    public Mono<Response> hashCpuLimited(@RequestParam("value") String value) throws InterruptedException {
        LOGGER.debug("called 'hashCpuLimited' with value={}", value);
        if (!concurrentAccessSemaphore.tryAcquire()) {
            throw new RuntimeException("Too much looooooooad!");
        }

        Integer timeoutValue = (MAX_CONCURRENT_USERS - concurrentAccessSemaphore.availablePermits()) * 100;

        LOGGER.info("Sleeping for " + timeoutValue);

        Thread.sleep(timeoutValue);

        Mono<Response> result = Mono.just(new Response(hash(value)));


        concurrentAccessSemaphore.release();

        return result;
    }

    @Scheduled(fixedRate = 250)
    public void showUsageInformation() {
        LOGGER.debug(concurrentAccessSemaphore.availablePermits() + " available slots for /api/hash-limited");
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
        wasteOfMemory.put(value, RandomStringUtils.randomAlphabetic(100000));

        return Mono.just(new Response(inMemoryValues.get(value)));
    }


    private String hash(String value) {
        return hash(value, 10);
    }

    private String hash(String value, int rounds) {
        LOGGER.info("Hashing with {} rounds", rounds);
        return BCrypt.hashpw(value, BCrypt.gensalt(rounds));
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

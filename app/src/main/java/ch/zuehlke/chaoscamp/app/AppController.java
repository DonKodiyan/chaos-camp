package ch.zuehlke.chaoscamp.app;

import io.micrometer.core.annotation.Timed;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;

    }

    @Timed(value = "api.hello")
    @GetMapping("api/hello")
    public String hash(@RequestParam("value") String value) {
        LOGGER.debug("called 'hash' with value={}", value);
        return appService.getHash(value);
    }

    @GetMapping("api/world")
    public String hashResilient(@RequestParam("value") String value) {
        LOGGER.debug("called 'hashResilient' with value={}", value);
        return appService.getHashResilient(value);
    }


    @Timed(value = "api.info")
    @GetMapping("api/info")
    public String info() {
        LOGGER.debug("called 'info'");
        return appService.getInfo();
    }

    @Timed(value = "api.cpu-intensive")
    @GetMapping("api/cpu-intensive")
    public String getCpuIntensiveTask() {
        LOGGER.debug("called 'getCpuIntensiveTask'");

        String value = RandomStringUtils.randomAlphabetic(10);

        return appService.getHash(value);
    }

    @Timed(value = "api.memory-intensive")
    @GetMapping("api/memory-intensive")
    public String getMemoryIntensiveTask() {
        LOGGER.debug("called 'getMemoryIntensiveTask'");
        String value = RandomStringUtils.randomAlphabetic(10);

        return appService.getHashMemoryIntensive(value);
    }
}

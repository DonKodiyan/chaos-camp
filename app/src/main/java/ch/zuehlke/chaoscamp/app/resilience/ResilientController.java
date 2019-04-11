package ch.zuehlke.chaoscamp.app.resilience;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResilientController {

    private final ResilientService resilientService;

    public ResilientController(ResilientService resilentService) {
        this.resilientService = resilentService;
    }


    @GetMapping("api/resilience/plain")
    public String plain() {
        return this.resilientService.plain();
    }

    @GetMapping("api/resilience/circuit-breaker")
    public String resilient() {
        return this.resilientService.circuitBreaker();
    }

    @GetMapping("api/resilience/retry")
    public String retry() {
        return this.resilientService.retry();
    }
}

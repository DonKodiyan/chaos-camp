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

    @GetMapping("api/resilience/bulkhead")
    public String bulkhead() {
        return this.resilientService.bulkhead();
    }

    @GetMapping("api/resilience/ratelimiter")
    public String ratelimiter() {
        return this.resilientService.ratelimiter();
    }

    @GetMapping("api/resilience/all-together")
    public String allTogether() {
        return this.resilientService.allTogether();
    }

    @GetMapping("api/resilience/hash-plain")
    public String hashPlain() {
        return this.resilientService.hashPlain(false, "/hash-sleeping");
    }

    @GetMapping("api/resilience/hash-circuit-breaker")
    public String hashCircuitBreaker() {
        return this.resilientService.hashCircuitBreaker();
    }

    @GetMapping("api/resilience/hash-toxic-plain")
    public String hashToxicPlain() {
        return this.resilientService.hashPlain(true, "/hash");
    }
}

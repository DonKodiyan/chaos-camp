package ch.zuehlke.chaoscamp.app.resilience;

public class CircuitBreakerRuntimeException extends RuntimeException {

    public CircuitBreakerRuntimeException(String message) {
        super(message);
    }

    public CircuitBreakerRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}

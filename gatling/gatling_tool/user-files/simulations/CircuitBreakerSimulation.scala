package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class CircuitBreakerSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")

  val circuitBreaker = scenario("Circuit breaker scenario")
    .exec(http("circuit-breaker")
      .get("/api/resilience/circuit-breaker"))

  setUp(
    circuitBreaker.inject(
      rampUsers(100) during (30 seconds)
    )
  ).protocols(httpProtocol)
}

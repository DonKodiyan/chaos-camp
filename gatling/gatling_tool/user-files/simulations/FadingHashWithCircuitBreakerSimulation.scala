package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class FadingHashWithCircuitBreakerSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")

  val circuitBreaker = scenario("Circuit breaker demo")
      .exec(http("with circuit-breaker")
        .get("/api/resilience/hash-circuit-breaker"))

  setUp(
    circuitBreaker.inject(
      constantUsersPerSec(20) during (60 seconds)
    )
  ).protocols(httpProtocol)
}

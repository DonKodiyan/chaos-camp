package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class FadingHashPlainSimulationSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")

  val circuitBreaker = scenario("Circuit breaker demo")
    .exec(http("without circuit-breaker")
      .get("/api/resilience/hash-plain"))

  setUp(
    circuitBreaker.inject(
      constantUsersPerSec(20) during (60 seconds)
    )
  ).protocols(httpProtocol)
}

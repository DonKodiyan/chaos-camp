package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class ToxicHashPlainSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")

  val circuitBreaker = scenario("Circuit breaker demo")
    .exec(http("without retry")
      .get("/api/resilience/hash-toxic-plain"))

  setUp(
    circuitBreaker.inject(
      constantUsersPerSec(10) during (120 seconds)
    )
  ).protocols(httpProtocol)
}

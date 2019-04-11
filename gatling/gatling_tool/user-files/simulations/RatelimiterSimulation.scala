package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class RatelimiterSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")

  val circuitBreaker = scenario("Ratelimiter scenario")
    .exec(http("ratelimiter")
      .get("/api/resilience/ratelimiter"))

  setUp(
    circuitBreaker.inject(
      rampUsersPerSec(1) to(20) during (60 seconds)
    )
  ).protocols(httpProtocol)
}

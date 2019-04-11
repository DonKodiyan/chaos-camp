package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class ResilientSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")

  val scn = scenario("Resilient scenario")
    .exec(http("plain")
      .get("/api/resilience/plain"))
    .pause(2)
    .exec(http("circuit-breaker")
      .get("/api/resilience/circuit-breaker"))
    .pause(2)
    .exec(http("retry")
      .get("/api/resilience/retry"))

  setUp(
    scn.inject(rampUsers(100) during (20 seconds)),
  ).protocols(httpProtocol)
}

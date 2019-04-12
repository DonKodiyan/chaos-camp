package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class PlainSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")

  val plain = scenario("Plain Scenario")
    .exec(http("api-info")
      .get("/api/info"))
    .exec(http("plain")
      .get("/api/resilience/plain"))

  setUp(
    plain.inject(
      rampUsersPerSec(1) to(30) during (60 seconds)
    )
  ).protocols(httpProtocol)
}

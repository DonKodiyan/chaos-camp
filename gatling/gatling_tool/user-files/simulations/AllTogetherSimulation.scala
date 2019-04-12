package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class AllTogetherSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")

  val plain = scenario("All together scenario")
    .exec(http("all-together")
      .get("/api/resilience/all-together"))

  setUp(
    plain.inject(
      rampUsersPerSec(1) to(10) during (60 seconds)
    )
  ).protocols(httpProtocol)
}

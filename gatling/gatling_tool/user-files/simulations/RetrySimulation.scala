package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class RetrySimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")

  val retry = scenario("Retry scenario")
    .exec(http("retry")
      .get("/api/resilience/retry"))

  setUp(
    retry.inject(
      rampUsersPerSec(1) to(15) during (60 seconds)
    )
  ).protocols(httpProtocol)
}

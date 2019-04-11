package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class BulkheadSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")

  val circuitBreaker = scenario("Bulkhead scenario")
    .exec(http("bulkhead")
      .get("/api/resilience/bulkhead"))

  setUp(
    circuitBreaker.inject(
      rampUsersPerSec(1) to(20) during (120 seconds)
    )
  ).protocols(httpProtocol)
}

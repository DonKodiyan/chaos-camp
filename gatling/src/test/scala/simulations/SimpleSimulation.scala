package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SimpleSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")

  val scn = scenario("Simple scenario") // A scenario is a chain of requests and pauses
    .exec(http("ping")
      .get("/api/ping?value=test"))
    .exec(http("hash")
      .get("/api/hello?value=test"))

  setUp(scn.inject(atOnceUsers(100)).protocols(httpProtocol))
}

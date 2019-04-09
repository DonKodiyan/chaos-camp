package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SimpleSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")

  val scn = scenario("Simple scenario") // A scenario is a chain of requests and pauses
    .exec(http("api-info")
      .get("/api/info"))
    .pause(1)
    .exec(http("hash")
      .get("/api/hello?value=test"))
    .pause(1)
    .exec(http("cpu-intensive")
      .get("/api/cpu-intensive"))
    .pause(1)
    .exec(http("memory-intensive")
      .get("/api/memory-intensive"))

  setUp(scn.inject(atOnceUsers(100)).protocols(httpProtocol))
}

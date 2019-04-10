package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class MemorySimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")

  val memoryIntensiveScenario = scenario("Memory-Intensive scenario")
    .exec(http("api-info")
    .get("/api/info"))
    .pause(1)
    .exec(http("memory-intensive")
      .get("/api/memory-intensive"))

  setUp(
    memoryIntensiveScenario.inject(rampUsers(2000) during (60 seconds))
  ).protocols(httpProtocol)
}

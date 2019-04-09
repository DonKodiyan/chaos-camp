package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class CPUSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081")

  val cpuIntensiveScenario = scenario("CPU-Intensive scenario")
    .exec(http("api-info")
    .get("/api/info"))
    .pause(1)
    .exec(http("cpu-intensive")
      .get("/api/cpu-intensive"))

  setUp(
    cpuIntensiveScenario.inject(rampUsers(2000) during (60 seconds)),
  ).protocols(httpProtocol)
}

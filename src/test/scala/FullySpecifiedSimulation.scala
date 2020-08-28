import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class FullySpecifiedSimulation extends Simulation {

  val baseHttpProtocol =
    http.baseUrl("https://computer-database.gatling.io")

  val scn = scenario("simplest")
    .exec(
      http("Home")
        .get("/")
    )

  setUp(
    scn.inject(
      rampUsersPerSec(1) to 200 during 1.minute,
      constantUsersPerSec(200) during 9.minutes
    )
  ).protocols(baseHttpProtocol)
    .assertions(
      global.requestsPerSec.gte(100),
      global.responseTime.percentile(99).lt(250),
      global.failedRequests.percent.lte(1)
    )
}

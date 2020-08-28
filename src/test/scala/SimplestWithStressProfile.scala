import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class SimplestWithStressProfile extends Simulation {

  val baseHttpProtocol =
    http.baseUrl("https://computer-database.gatling.io")

  val scn = scenario("simplest")
    .exec(
      http("Home")
        .get("/")
    )

  setUp(
    scn.inject(
      rampUsers(1000000) during 5.minutes
    )
  ).protocols(baseHttpProtocol)
}

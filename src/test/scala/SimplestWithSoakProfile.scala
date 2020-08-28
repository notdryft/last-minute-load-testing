import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class SimplestWithSoakProfile extends Simulation {

  val baseHttpProtocol =
    http.baseUrl("https://computer-database.gatling.io")

  val scn = scenario("simplest")
    .exec(
      http("Home")
        .get("/")
    )

  setUp(
    scn.inject(
      // rampUsers(1000000) during 2.hours,
      // or
      rampUsersPerSec(1) to 150 during 1.minute,
      constantUsersPerSec(150) during 2.hours
    )
  ).protocols(baseHttpProtocol)
}

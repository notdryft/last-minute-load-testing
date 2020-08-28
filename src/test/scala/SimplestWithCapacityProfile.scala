import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class SimplestWithCapacityProfile extends Simulation {

  val baseHttpProtocol =
    http.baseUrl("https://computer-database.gatling.io")

  val scn = scenario("simplest")
    .exec(
      http("Home")
        .get("/")
    )

  setUp(
    scn.inject(
      incrementUsersPerSec(10)
        .times(3)
        .eachLevelLasting(2.minutes)
        .separatedByRampsLasting(30.seconds) // optional
        .startingFrom(10) // in users per sec
    )
  ).protocols(baseHttpProtocol)
}

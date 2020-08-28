import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SimplestPossibleSimulation extends Simulation {

  val baseHttpProtocol =
    http.baseUrl("https://computer-database.gatling.io")

  val scn = scenario("simplest")
    .exec(
      http("Home")
        .get("/")
    )

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(baseHttpProtocol)
}

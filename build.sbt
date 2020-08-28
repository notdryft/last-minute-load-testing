enablePlugins(GatlingPlugin, FrontLinePlugin)

scalaVersion := "2.12.12"

scalacOptions := Seq("-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation", "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.3.1" % "test",
  "io.gatling"            % "gatling-test-framework"    % "3.3.1" % "test"
)

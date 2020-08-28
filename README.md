This is both a Maven and SBT project, in which you can run the previous simulation using either:

```
mvn gatling:test -Dgatling.simulationClass=SimplestPossibleSimulation
```

With Maven, or using SBT:

```
sbt “gatling:testOnly SimplestPossibleSimulation”
```

Inside the `src/test/resources` folder, you will find two files: `gatling.conf` and `logback.xml`. The first one is useful to tweek Gatling’s behavior or, uncommenting the following line of the `logback.xml` file:

```xml
<!-- uncomment and set to DEBUG to log all failing HTTP requests -->
<!-- uncomment and set to TRACE to log all HTTP requests -->
<logger name="io.gatling.http.engine.response" level="TRACE" />
```

This is useful if you want to have all the background details of the running test, including payloads, headers, body and the content of either all the reponses, or only the responses of the requests that “failed”.

I would suggest not uncommenting this when running a production scaled test, as dumping all the errors will slow down the throughput of the test dramatically. This is only for debugging purposes.

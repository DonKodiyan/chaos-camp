# Gatling load tests

## Simple load test

To test it out, simply execute the following command:

    $mvn gatling:test -Dgatling.simulationClass=simulations.SimpleSimulation

or simply:

    $mvn gatling:test

Find the report in the following folder:

    ./target/gatling/*
    
    
source: https://github.com/gatling/gatling-maven-plugin-demo
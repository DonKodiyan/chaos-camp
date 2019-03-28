# syntax=docker/dockerfile:experimental
FROM maven:3.6-jdk-11 AS build-stage
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN --mount=type=cache,target=/root/.m2 mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:11-jdk-slim AS production-stage
COPY --from=build-stage /usr/src/app/target/hasher-0.0.1-SNAPSHOT.jar /usr/app/hasher-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/usr/app/hasher-0.0.1-SNAPSHOT.jar"]
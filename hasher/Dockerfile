FROM maven:3.3.9-jdk-8 AS build-stage
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:8-jre-alpine AS production-stage
COPY --from=build-stage /usr/src/app/target/hasher-0.0.1-SNAPSHOT.jar /usr/app/hasher-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/usr/app/hasher-0.0.1-SNAPSHOT.jar"]
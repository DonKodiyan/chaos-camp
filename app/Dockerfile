FROM maven:3.6-jdk-11 AS build-stage
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:11-jdk-slim AS production-stage
COPY --from=build-stage /usr/src/app/target/app-0.0.1-SNAPSHOT.jar /usr/app/app-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=kubernetes", "/usr/app/app-0.0.1-SNAPSHOT.jar"]
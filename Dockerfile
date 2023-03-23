FROM maven:3.8.6-eclipse-temurin-17-alpine as build
WORKDIR .
COPY . .
RUN mvn clean package spring-boot:repackage

FROM openjdk:17-slim as producer1
COPY --from=build target /target/
CMD ["java", "-jar", "target/fowu-producer-spring-0.0.1-SNAPSHOT.jar"]






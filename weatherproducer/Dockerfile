FROM maven:3.8.6-eclipse-temurin-17-alpine as build

# Set the working directory inside the container
WORKDIR /build/

# Copy the top-level pom.xml file and download all dependencies to cache them
COPY ./pom.xml /build/

# # Copy the 'common' module and build it
# COPY ./common/pom.xml ./common/src /build/common/
# RUN cd common && mvn clean package

# Copy the current module and build it
COPY ./weatherproducer/pom.xml ./weatherproducer/src /build/producer/

RUN cd producer && mvn clean package spring-boot:repackage

FROM openjdk:17-slim as weather-producer
COPY --from=build producer/target/weatherproducer-0.0.1-SNAPSHOT.jar weatherproducer.jar
CMD ["java", "-jar", "weatherproducer.jar"]






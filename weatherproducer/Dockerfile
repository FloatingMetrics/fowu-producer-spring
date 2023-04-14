FROM maven:3.8.6-eclipse-temurin-17-alpine as build
# NOTE: Context is top-level project
# Set the working directory inside the container
WORKDIR /build/

# Copy the top-level pom.xml file
COPY ./pom.xml /build/

# Copy the current module pom and source files
COPY ./weatherproducer/pom.xml ./weatherproducer/src /build/producer/

# Copy common jar file
COPY --from=producers-common common-0.0.1-SNAPSHOT.jar /build/common/target/

RUN cd producer && mvn clean package spring-boot:repackage

FROM openjdk:17-slim as weather-producer
COPY --from=build producer/target/weatherproducer-0.0.1-SNAPSHOT.jar weatherproducer.jar
CMD ["java", "-jar", "weatherproducer.jar"]






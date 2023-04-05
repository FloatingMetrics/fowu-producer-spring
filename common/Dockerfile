FROM maven:3.8.6-eclipse-temurin-17-alpine as build

# Set the working directory inside the container
WORKDIR .

# Copy the top-level pom.xml file and download all dependencies to cache them
COPY ./pom.xml ../pom.xml

# Copy the 'common' module and build it
COPY . .
RUN cd common && mvn clean package

FROM openjdk:17-slim as producers-common
COPY --from=build common/target/common-0.0.1-SNAPSHOT.jar common.jar






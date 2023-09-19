FROM openjdk:17-slim as weather-producer
COPY ./weatherproducer/target/weatherproducer-0.0.1-SNAPSHOT.jar weatherproducer.jar
CMD ["java", "-jar", "weatherproducer.jar"]






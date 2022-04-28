FROM openjdk:17-alpine3.14
WORKDIR /application
COPY target/NorthwindApp-0.0.1-SNAPSHOT.jar ./
CMD ["java", "-jar", "NorthwindApp-0.0.1-SNAPSHOT.jar"]


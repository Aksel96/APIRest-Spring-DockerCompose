FROM amazoncorretto:24.0.1-alpine3.21
LABEL authors="Aksel"
ARG JAR_FILE=./target/videojuegos-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_videojuegos.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_videojuegos.jar"]
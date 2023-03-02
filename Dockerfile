FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/restaurante-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} restaurante-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "restaurante-api.jar"]

# FROM openjdk:8-jdk-alpine
# VOLUME /main-app
# ADD build/libs/restaurante-0.0.1-SNAPSHOT.jar restaurante-api.jar
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar","/restaurante-api.jar"]
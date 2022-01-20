FROM openjdk:8-jdk-alpine
ADD target/TP-0.0.1-SNAPSHOT.jar TP-0.0.1-SNAPSHOT.jar
ARG DEPENDENCY=target/dependency
ENTRYPOINT ["java", "-jar", "TP-0.0.1-SNAPSHOT.jar"]
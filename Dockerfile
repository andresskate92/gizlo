FROM openjdk:8-jdk-slim
VOLUME /tmp
EXPOSE 8089
ARG JAR_FILE=target/appBackGizlo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} appBackGizlo.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/appBackGizlo.jar"]
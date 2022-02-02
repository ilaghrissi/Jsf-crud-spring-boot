FROM openjdk:openjdk:8-jdk-alpine
MAINTAINER tuto
VOLUME D:/tmp
ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} jsf.war
ENTRYPOINT ["java","-jar","/jsf.war"]
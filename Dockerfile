FROM openjdk:8-jdk-alpine
MAINTAINER tutorials team
ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} jsf.war
ENTRYPOINT ["java","-jar","jsf.war"]
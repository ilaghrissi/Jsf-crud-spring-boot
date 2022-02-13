FROM openjdk:openjdk:8-jdk-alpine
MAINTAINER tutorials team
VOLUME D:/tmp
ARG WAR_FILE=/*.war
ADD ${WAR_FILE} jsf.war
ENTRYPOINT ["java","-jar","/jsf.war"]
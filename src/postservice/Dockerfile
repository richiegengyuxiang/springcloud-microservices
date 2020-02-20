FROM openjdk:8-jdk-alpine
COPY target/*.jar postservice.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/postservice.jar"]

FROM openjdk:8
WORKDIR	/usr/src/postservice
COPY target/*.jar postservice.jar
EXPOSE 8082
CMD ["java","-jar","postservice.jar"]

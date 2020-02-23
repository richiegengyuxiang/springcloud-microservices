FROM openjdk:8
WORKDIR	/usr/src/postservice
COPY target/postservice-0.0.1-SNAPSHOT.jar postservice.jar
EXPOSE 8082
EXPOSE 80 2222
CMD ["java","-jar","postservice.jar"]

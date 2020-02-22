FROM maven:3.6-jdk-8
WORKDIR	/usr/src/postservice
COPY . .
EXPOSE 8082
EXPOSE 80 2222
RUN mvn install
CMD ["java","-jar","target/postservice-0.0.1-SNAPSHOT.jar"]

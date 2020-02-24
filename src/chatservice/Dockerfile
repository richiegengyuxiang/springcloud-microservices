FROM maven:3.6-jdk-8
WORKDIR	/usr/src/chatservice
#COPY target/postservice-0.0.1-SNAPSHOT.jar postservice.jar
COPY . .
# RUN mvn package -Dmaven.test.skip=true
EXPOSE 8083
EXPOSE 80 2222
# CMD ["java","-jar","target/postservice-0.0.1-SNAPSHOT.jar"]
CMD ["mvn","spring-boot:run"]

FROM maven:3.6-jdk-8
WORKDIR	/usr/src/authservice
#COPY target/authservice-0.0.1-SNAPSHOT.jar authservice.jar
COPY . .
# RUN mvn package -Dmaven.test.skip=true
EXPOSE 8080
EXPOSE 80 2222
# CMD ["java","-jar","target/authservice-0.0.1-SNAPSHOT.jar"]
CMD ["mvn", "spring-boot:run"]


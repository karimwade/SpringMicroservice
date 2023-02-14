#Premiere etape
from maven:3.8.3-openjdk-17 as build
copy src /SpringTestMicroservice/src
copy pom.xml /SpringTestMicroservice
run mvn -f /SpringTestMicroservice/pom.xml clean package

#Deuxieme etape
from openjdk:17-jdk-alpine
Expose 8080
Add target/spring-test-microservice.jar spring-test-microservice.jar
Entrypoint ["java","-jar","spring-test-microservice.jar"]
from java:17

Expose 8080
Add \target\SpringTestMicroservice-0.0.1-SNAPSHOT.jar
Entrypoint ["java","-jar","/SpringTestMicroservice-0.0.1-SNAPSHOT.jar"]
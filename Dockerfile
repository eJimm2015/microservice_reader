FROM openjdk:14
ADD target/microservice-reader.jar /microservice-reader.jar
EXPOSE 8002
ENTRYPOINT ["java","-jar","/microservice-reader.jar"]
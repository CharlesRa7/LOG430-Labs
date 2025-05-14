FROM openjdk:21-jdk-slim
COPY target/*.jar lab.jar
ENTRYPOINT ["java","-jar","/lab.jar"]
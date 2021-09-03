FROM openjdk:18-jdk-slim 
maintainer burgos
arg JAR_FILE=target/*.jar
copy ${JAR_FILE} perficienttraining.jar
entrypoint ["java","-jar", "/perficienttraining.jar"]
 

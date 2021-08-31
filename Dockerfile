FROM openjdk:18-jdk-slim 
maintainer burgos
arg JAR_FILE=target/*.jar
copy ${JAR_FILE} perficientTraining.jar
entrypoint ["java","-jar", "/perficientTraining.jar"]
 

FROM openjdk:8-jdk-alpine

#COPY target/MyWebApp-1-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

COPY target/MyWebApp-1-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java","-jar","/app.war"]
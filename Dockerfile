FROM openjdk:17
MAINTAINER R.Prystynskyi
EXPOSE 8080
COPY target/restServer-spring-boot.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
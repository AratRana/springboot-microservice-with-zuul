FROM openjdk:8
ADD target/platform-eureka-server.jar platform-eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "platform-eureka-server.jar"]
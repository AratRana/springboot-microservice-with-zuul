FROM openjdk:8
ADD target/platform-config-server.jar platform-config-server.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "platform-config-server.jar"]

#CMD ["java", "-jar", "platform-config-server.jar"]
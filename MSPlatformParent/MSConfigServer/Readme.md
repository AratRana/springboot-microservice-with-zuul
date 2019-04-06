docker build -f Dockerfile -t platform-config-server .
docker images
docker run -p 8090:8090 platform-config-server

C:\arat\R_N_D\microservices_workspace1111\MSPlatformParent>docker-compose up
C:\arat\R_N_D\microservices_workspace1111\MSPlatformParent>docker-compose down

docker container run --name config-server -p 8090:8090 -d platform-config-server

docker network ls

docker network create <networkname>


docker container run --network <networkname> --name config-server -p 8090:8090 -d platform-config-server

docker container run -d -p 8090:8090 platform-config-server


spring:
  profiles:
    include:
    - native, git
    active:
    - native, git
  cloud:
    config:
      server:
        git:
          uri: https://github.com/AratRana/spring-boot-microservice-config-repo
      enabled: true    
      
docker build -f Dockerfile -t platform-eureka-server .
docker images
docker run -p 8761:8761 platform-eureka-server

docker run -d -p 8761:8761 platform-eureka-server

docker rm <imageid>
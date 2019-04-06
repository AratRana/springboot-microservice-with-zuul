docker service create  -d --name discovery --network jdaplatformbridge --replicas 1 -p 8761:8761 platform-eureka-server
	
docker service create  -d --name configserver --network jdaplatformbridge --replicas 1 -p 8090:8090 platform-config-server

docker service create  -d --name platform-core --network jdaplatformbridge --replicas 1 -p 8093:8093 platform-core

docker service create  -d --name platform-ui --network jdaplatformbridge --replicas 1 -p 8098:8098 platform-ui

docker service create  -d --name platform-hystrix --network jdaplatformbridge --replicas 1 -p 8084:8084 platform-hystrix

docker service create  -d --name platform-zuul-ui --network jdaplatformbridge --replicas 1 -p 8087:8087 platform-zuul-ui
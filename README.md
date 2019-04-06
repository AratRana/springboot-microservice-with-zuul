# springboot-microservice-with-zuul

open application.xml of config server and change the central config location to git:
spring:
  cloud:
    config:
      server:
        git:
          uri:https://github.com/AratRana/spring-boot-microservice-config-repo
          
          
open: c:\Windows\System32\drivers\etc\hosts  in admin mode and add the           

127.0.0.1	configserver
127.0.0.1	discovery
127.0.0.1	dbhost
127.0.0.1	apihost

If all all are in local or change the ip accordingly

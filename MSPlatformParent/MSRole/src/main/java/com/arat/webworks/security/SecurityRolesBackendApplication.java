package com.arat.webworks.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SecurityRolesBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityRolesBackendApplication.class, args);
	}

}

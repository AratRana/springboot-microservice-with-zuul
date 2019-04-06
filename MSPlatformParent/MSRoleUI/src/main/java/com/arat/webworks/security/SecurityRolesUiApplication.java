package com.arat.webworks.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrix
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
@EnableZuulProxy
public class SecurityRolesUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityRolesUiApplication.class, args);
	}

}

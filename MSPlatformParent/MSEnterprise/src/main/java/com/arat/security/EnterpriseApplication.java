package com.arat.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class EnterpriseApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(EnterpriseApplication.class);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EnterpriseApplication.class);
	}
}

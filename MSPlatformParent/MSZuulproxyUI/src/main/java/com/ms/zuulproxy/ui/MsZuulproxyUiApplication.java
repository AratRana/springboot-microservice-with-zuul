package com.ms.zuulproxy.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
//import org.springframework.retry.annotation.EnableRetry;

@EnableZuulProxy
@EnableEurekaClient
//@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@SpringBootApplication
@EnableDiscoveryClient
//@EnableRetry
/*
 * @RibbonClients({
 * 
 * @RibbonClient(name = "enterpriseserviceui"),
 * 
 * @RibbonClient(name = "roleserviceui")})
 */
public class MsZuulproxyUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsZuulproxyUiApplication.class, args);
	}
	
}


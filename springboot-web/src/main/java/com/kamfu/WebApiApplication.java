package com.kamfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.log4j.Log4j2;
@SpringBootApplication
@ComponentScan(value="com.kamfu")
@Log4j2
@EnableEurekaClient
@EnableDiscoveryClient  //服务的发现, 暴露出来
public class WebApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(WebApiApplication.class, args);
		log.info(WebApiApplication.class.getSimpleName() + " is success!");
	}
}

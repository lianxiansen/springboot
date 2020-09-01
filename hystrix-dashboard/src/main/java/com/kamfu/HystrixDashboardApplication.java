package com.kamfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.log4j.Log4j2;
@EnableHystrixDashboard
@SpringBootApplication
@ComponentScan(value="com.kamfu")
@Log4j2
public class HystrixDashboardApplication {


	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
		log.info(HystrixDashboardApplication.class.getSimpleName() + " is success!");
	}
}

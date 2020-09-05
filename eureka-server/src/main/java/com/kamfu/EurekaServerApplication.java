package com.kamfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	//java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=eureka1
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}

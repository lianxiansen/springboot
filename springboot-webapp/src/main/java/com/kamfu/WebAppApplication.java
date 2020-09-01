package com.kamfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j2;
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.kamfu.*")
@Log4j2
@EnableFeignClients
@EnableHystrix
public class WebAppApplication {

	@LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
		log.info(WebAppApplication.class.getSimpleName() + " is success!");
	}
}

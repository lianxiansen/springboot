package com.kamfu.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;



import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.kamfu.*")
@Log4j2
public class WebAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
		log.info(WebAppApplication.class.getSimpleName() + " is success!");
	}
}

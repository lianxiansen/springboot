package com.kamfu.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.kamfu.web.controller.LoginController;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
@SpringBootApplication
@ComponentScan(basePackages = "com.kamfu.*")
@Log4j2
public class WebApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(WebApiApplication.class, args);
		log.info(WebApiApplication.class.getSimpleName() + " is success!");
	}
}

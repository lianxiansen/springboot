package com.kamfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
//@EnableZuulProxy简单理解为@EnableZuulServer的增强版，当Zuul与Eureka、Ribbon等组件配合使用时，我们使用@EnableZuulProxy。
@EnableZuulProxy
@SpringBootApplication
//@EnableDiscoveryClient      // 开启eureka客户端的消费者
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
}

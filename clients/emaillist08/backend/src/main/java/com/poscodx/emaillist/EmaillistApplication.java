package com.poscodx.emaillist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmaillistApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmaillistApplication.class, args);
	}
	
	
	//Resttemplate 사용시 LB 필수
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
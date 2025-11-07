package com.example.api_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//하위 프로젝트 스캔
@SpringBootApplication(scanBasePackages = {"com.example.api_service", "com.example.product_service", "com.example.order_service", "com.example.user_service"})
public class ApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiServiceApplication.class, args);
	}

}

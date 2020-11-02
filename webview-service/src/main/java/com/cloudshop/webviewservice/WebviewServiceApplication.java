package com.cloudshop.webviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WebviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebviewServiceApplication.class, args);
	}

}

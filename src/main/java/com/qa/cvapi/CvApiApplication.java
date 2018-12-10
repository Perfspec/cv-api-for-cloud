package com.qa.cvapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CvApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvApiApplication.class, args);
	}
}

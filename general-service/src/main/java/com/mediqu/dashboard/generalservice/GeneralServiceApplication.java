package com.mediqu.dashboard.generalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GeneralServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneralServiceApplication.class, args);
	}
	
	  @LoadBalanced
	  @Bean("restTemplate")
	  RestTemplate getRestTemplate() {
	      return new RestTemplate();
	  }

}

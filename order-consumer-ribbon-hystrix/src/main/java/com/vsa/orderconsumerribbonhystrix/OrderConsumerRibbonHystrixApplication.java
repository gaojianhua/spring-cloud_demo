package com.vsa.orderconsumerribbonhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication*/
@SpringCloudApplication
public class OrderConsumerRibbonHystrixApplication {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		//RestTemplate template = new RestTemplate();
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderConsumerRibbonHystrixApplication.class, args);
	}

}

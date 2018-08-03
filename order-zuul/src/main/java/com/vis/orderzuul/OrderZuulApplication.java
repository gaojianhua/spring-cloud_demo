package com.vis.orderzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


/**
 *  访问: http://localhost:7777/order-server/dc
 *
 *  即可访问order-server服务的dc
 */
@EnableZuulProxy
@SpringCloudApplication
public class OrderZuulApplication {

	@Bean
	public AccessFilter accessFilter(){
		AccessFilter accessFilter = new AccessFilter();
		return accessFilter;
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderZuulApplication.class, args);
	}
}

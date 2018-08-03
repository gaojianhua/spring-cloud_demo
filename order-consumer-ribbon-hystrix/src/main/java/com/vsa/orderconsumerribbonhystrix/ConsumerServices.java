package com.vsa.orderconsumerribbonhystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class ConsumerServices {

    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        return "ribbon-hystrix "+restTemplate.getForObject("http://order-server/dc", String.class);
    }
    public String fallback() {
        return "fallback";
    }
}

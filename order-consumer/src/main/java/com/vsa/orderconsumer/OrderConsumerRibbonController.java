package com.vsa.orderconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class OrderConsumerRibbonController {

        @Autowired
        RestTemplate restTemplate;
        @GetMapping("/order/ribbon")
        public String dc(){
            return "ribbon-"+restTemplate.getForObject("http://order-server/dc", String.class);
        }
}

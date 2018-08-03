package com.vsa.orderconsumerribbonhystrix;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class OrderConsumerRibbonHystrix {

    @Autowired
    public ConsumerServices consumerServices;

    @GetMapping("/order/hystrix")
    public String hystrix(){
        return consumerServices.consumer();
    }

@Service
class ConsumerServices {

    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        return "ribbon-hystrix "+restTemplate.getForObject("http://order-server/dc", String.class);
    }
    public String fallback() {
        System.out.println("fallback-hystix-robin");
        return "fallback-hystix-robin";
    }

    }
}



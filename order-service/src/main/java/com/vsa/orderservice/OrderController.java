package com.vsa.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc(){
        try {
            System.out.println("order service 正在休息!");
            Thread.sleep(500000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String service_name = "Services :"+discoveryClient.getServices().toString();
        System.out.println(service_name);

        return  service_name;
    }
}

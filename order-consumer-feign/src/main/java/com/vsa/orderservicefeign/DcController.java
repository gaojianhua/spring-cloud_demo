package com.vsa.orderservicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {
    @Autowired
    DcClient dcClient;

    @GetMapping("/order/feign")
    public String conusmer(){
        return dcClient.consumer();
    }
}

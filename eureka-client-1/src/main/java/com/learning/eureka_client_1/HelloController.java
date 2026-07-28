package com.learning.eureka_client_1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String getHello(){
        return "I am eureka client-1";
    }
}

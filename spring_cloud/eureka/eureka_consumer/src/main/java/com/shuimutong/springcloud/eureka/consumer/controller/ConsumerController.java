package com.shuimutong.springcloud.eureka.consumer.controller;

import com.shuimutong.springcloud.eureka.consumer.middleservice.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private HelloRemote helloRemote;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        System.out.println("consumer,,index,/hello/,,," + name);
        return helloRemote.hello(name);
    }
}

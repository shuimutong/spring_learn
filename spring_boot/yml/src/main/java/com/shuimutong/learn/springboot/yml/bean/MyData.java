package com.shuimutong.learn.springboot.yml.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class MyData {
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;
    @Value("${my.info}")
    private String info;
}

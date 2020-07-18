package com.shuimutong.learn.springboot.yml.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "stu-jack")
public class Student {
    private String name;
    private int age;
}

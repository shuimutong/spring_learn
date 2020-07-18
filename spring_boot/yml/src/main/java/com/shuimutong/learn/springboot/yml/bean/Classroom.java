package com.shuimutong.learn.springboot.yml.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "classroom")
public class Classroom {
    private String clazz;
    private String grade;
    private int seatNum;
    private List<String> courses;
    private List<Student> students;
}

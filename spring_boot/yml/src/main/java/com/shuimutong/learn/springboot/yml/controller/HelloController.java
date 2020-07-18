package com.shuimutong.learn.springboot.yml.controller;

import com.alibaba.fastjson.JSON;
import com.shuimutong.learn.springboot.yml.bean.Classroom;
import com.shuimutong.learn.springboot.yml.bean.MyData;
import com.shuimutong.learn.springboot.yml.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {
    @Resource
    private MyData myData;
    @Resource
    private Classroom classroom;
    @Resource
    private Student student;



    @GetMapping("/hello2")
    public String hello2() {
        return "Hello, Jack!";
    }

    @GetMapping("/getData")
    public MyData getMyData() {
        return myData;
    }

    @GetMapping("/classInfo")
    public Classroom getClassroomInfo() {
        System.out.println("this is stu:" + JSON.toJSONString(student));
        return classroom;
    }
}

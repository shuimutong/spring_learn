package com.shuimutong.learn.springboot.yml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class YmlApplication {
    public static void main(String[] args) {
//        SpringApplication.run(YmlApplication.class, args);

        SpringApplicationBuilder builder = new
                SpringApplicationBuilder(YmlApplication.class);
        builder.application().setAdditionalProfiles("prod");
        builder.run(args);
    }
}

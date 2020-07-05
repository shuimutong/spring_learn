package com.shuimutong.learn.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shuimutong.learn.mybatis.dao") //这个注解从运行结果看：加不加都行
//如果不加，只扫描和主类处于同包下的Class  https://blog.csdn.net/lisheng19870305/article/details/102816358
public class MybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}

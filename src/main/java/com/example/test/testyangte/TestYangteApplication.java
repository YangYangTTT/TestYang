package com.example.test.testyangte;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
//启动定时任务
@EnableScheduling
@MapperScan(basePackages ="com.example.test.testyangte.dao" )
@SpringBootApplication
public class TestYangteApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestYangteApplication.class, args);
    }

}

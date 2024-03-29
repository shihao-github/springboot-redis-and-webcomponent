package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.atguigu.dao")
@ServletComponentScan
public class MyApplication {
    public static void main(String[] args) {
        System.out.println("1111");
        System.out.println("2222");
        System.out.println("3333");
        System.out.println("4444");
        System.out.println("i am master");
        System.out.println("i am hotfix");
        SpringApplication.run(MyApplication.class, args);
    }
}

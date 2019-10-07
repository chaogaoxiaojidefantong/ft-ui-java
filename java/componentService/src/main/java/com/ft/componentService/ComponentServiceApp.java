package com.ft.componentService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.annotation.TypeAlias;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.ft.componentService.dao")
@TypeAlias("com.ft.common.pojo")
public class ComponentServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ComponentServiceApp.class,args);
    }
}

package com.ftui.adminService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@MapperScan
@SpringBootApplication
@EnableEurekaClient
public class AdminServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApp.class,args);
    }
}

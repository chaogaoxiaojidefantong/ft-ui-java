package com.ftui.articleService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.ftui.articleService.mapper")
@SpringBootApplication
@EnableEurekaClient
public class ArticleServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ArticleServiceApp.class,args);
    }
}

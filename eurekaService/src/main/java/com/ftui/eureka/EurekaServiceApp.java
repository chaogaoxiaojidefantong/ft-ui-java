package com.ftui.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApp {
    public  static  Logger logger = LoggerFactory.getLogger(EurekaServiceApp.class);
    public static void main(String[] args) {
        logger.error("xixi");
        logger.info("gggg");
        SpringApplication.run(EurekaServiceApp.class,args);
    }
}

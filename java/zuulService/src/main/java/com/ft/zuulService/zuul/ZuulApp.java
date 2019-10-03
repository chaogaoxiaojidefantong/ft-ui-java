package com.ft.zuulService.zuul;
import com.ft.common.vo.DiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@SpringBootApplication
@EnableZuulProxy
@RestController
@EnableFeignClients
public class ZuulApp {

    @Autowired
    HelloClient client;

    @RequestMapping("/")
    public DiliResult hello() {
        return client.hello();
    }



    public static void main(String[] args) {
        SpringApplication.run(ZuulApp.class,args);
    }

    @FeignClient("adminService")
    interface HelloClient {
        @RequestMapping("/Assets/he")
        DiliResult hello();
    }
}

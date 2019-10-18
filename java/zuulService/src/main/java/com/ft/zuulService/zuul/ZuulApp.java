package com.ft.zuulService.zuul;
import com.ft.common.vo.DiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableZuulProxy
@Controller
@EnableFeignClients
public class ZuulApp {

    @Autowired
    HelloClient client;

    @RequestMapping("/")
    @ResponseBody
    public DiliResult hello() {
        return client.hello();
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/hello")
    public String he(){
        return "hello";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
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

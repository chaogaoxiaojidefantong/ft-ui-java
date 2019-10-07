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
        int []arr={42,20,17,13,28,14,23,15};
        arr= quickSort(arr,0,7);
        System.out.println(arr);
        return client.hello();
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    public   int [] quickSort(int a[],int l,int r){
        if(l>=r)
            return null;
        int i = l; int j = r; int key = a[l];//选择第一个数为key
        int g[]={42,20,17,13,28,14,23,15};
        while(i<j){
            while(i<j && a[j]>=key)//从右向左找第一个小于key的值
                j--;
            if(i<j){
                a[i] = a[j];
                i++;
            }
            while(i<j && a[i]<key)//从左向右找第一个大于key的值
                i++;
            if(i<j){
                a[j] = a[i];
                j--;
            }
        }
        //i == j
        a[i] = key;
        quickSort(a, l, i-1);//递归调用
        quickSort(a, i+1, r);//递归调用
        return a;
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

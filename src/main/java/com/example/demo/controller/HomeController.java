package com.example.demo.controller;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.util.MyController;
import org.springframework.web.bind.annotation.RestController;

@MyController(value = "2",value3 = "3")
@RequestMapping("/")
public class HomeController {
    enum Level {
        LOW,
        MEDIUM,
        HIGH
    }
    @RequestMapping("/hello")
    public  String sayHello(){
       MyController myController= AnnotationUtils.getAnnotation(this.getClass(),MyController.class);
       String a1= myController.value2();
       String a2=myController.value3();
        Level a= Level.HIGH;
         return  "hello";
    }


}

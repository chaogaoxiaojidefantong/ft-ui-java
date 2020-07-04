package com.example.demo.controller;

import com.example.demo.pojo.UserGo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping("/User")
public class UserController {

    @RequestMapping("/login")
    public UserGo login(UserGo user){
        user.setUserName("sansan");
        user.setUserId(1l);
        return user;
    }
}

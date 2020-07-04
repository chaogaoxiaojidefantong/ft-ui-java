package com.ftui.userService.controller;

import com.ftui.common.vo.BiliResult;
import com.ftui.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/User")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/sayhello")
    public BiliResult sayHello(){
        return BiliResult.oK("nihao");
    }

    @RequestMapping("/sendMes")
    public BiliResult sendMes(String mes){
        return userService.sendMes(mes);
    }

}

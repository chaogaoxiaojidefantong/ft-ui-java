package com.ftui.userService.controller;

import com.ftui.common.pojo.User;
import com.ftui.common.vo.BiliResult;
import com.ftui.userService.config.aop.SysLog;
import com.ftui.userService.config.exception.SystemException;
import com.ftui.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/sayhello")
    @SysLog("测试")
    public BiliResult sayHello(){
        userService.hello();
        return BiliResult.oK("nihao");
    }



    @RequestMapping("/sendMes")
    public BiliResult sendMes(@RequestParam(required = false) String mes){
        if (mes==null){
            throw new SystemException("22");
        }
         return   userService.sendMes(mes);
    }
    @PostMapping("/regist")
    public  BiliResult regist(User user){
        return  userService.regist(user);
    }
    @PostMapping("/login")
    public BiliResult login(User user){
    return  userService.login(user);
    }
    @PostMapping("sendMesToAdmin")
    public BiliResult sendMesToAdmin(String mes){
        return userService.sendMesToAdmin(mes);
    }

    @PostMapping("/checkoutToken")
    public BiliResult checkTokenTest(String  token){
       return userService.checkTokenTest(token);
    }

    @GetMapping("/getUserByToken")
    public BiliResult getUserByToken(HttpServletRequest request){
        return  userService.getUserByToken(request);
    }

}
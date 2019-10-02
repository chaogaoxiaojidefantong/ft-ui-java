package com.ft.adminService.controller;
import com.ft.common.pojo.User;
import com.ft.adminService.service.UserService;
import com.ft.common.vo.DiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User/")
public class UserController {



    @Autowired
    UserService userService;

    @RequestMapping("regist")
    public DiliResult regist(User user){
        return userService.regist(user);
    }
    @RequestMapping("login")
    public DiliResult login(User user){
        return userService.login(user);
    }

    @RequestMapping("sendCode")
    public DiliResult sendCode(User user){
        return userService.sendCode(user);
    }

    @RequestMapping("logout")
    public DiliResult logout(String token){
        return  userService.logout(token);
    }

    @RequestMapping("loginByCode")
    public DiliResult loginByCode(User user){
        return userService.loginBycode(user);
    }

    @RequestMapping("updateUserByCode")
    public DiliResult updateUserByCode(User user){
        return userService.updateUserByCode(user);
    }

    @RequestMapping("updateUser")
    public DiliResult updateUser(User user){
        return userService.updateUser(user);
    }
}

package com.ftui.adminService.controller;

import com.ftui.adminService.service.AdminService;
import com.ftui.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    public BiliResult getKa(){
      return   adminService.getKa();
    }
}

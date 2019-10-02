package com.ft.adminService.controller;

import com.ft.adminService.service.AssetsService;
import com.ft.common.vo.DiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Assets/")
public class AssetsController {

    @Autowired
    AssetsService assetsService;


    @RequestMapping("selectAll")
    public DiliResult selectAll(){
        return assetsService.selectAll();
    }


}

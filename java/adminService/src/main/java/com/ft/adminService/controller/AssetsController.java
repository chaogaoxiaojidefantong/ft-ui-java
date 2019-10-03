package com.ft.adminService.controller;

import com.ft.adminService.service.AssetsService;
import com.ft.common.vo.DiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@RequestMapping("/Assets/")
public class AssetsController {

    @Autowired
    AssetsService assetsService;

    @Autowired
    DiscoveryClient discoveryClient;



    @RequestMapping("selectAll")
    public DiliResult selectAll(){
        return assetsService.selectAll();
    }

    @RequestMapping("/he")
    public DiliResult hello() {
        return DiliResult.oK(assetsService.selectAll());
    }
}

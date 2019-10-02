package com.ft.adminService.service;

import com.ft.adminService.dao.AssetsMapper;
import com.ft.common.pojo.Assets;
import com.ft.common.vo.DiliResult;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetsService {

    @Autowired
    AssetsMapper assetsMapper;



    @Value("${file.dir}")
    private String fileDir;

    @Value("${file.url}")
    private String fileUrl;



    //返回所有的assets对象
   public DiliResult selectAll(){

       return DiliResult.oK("nihao");
   }



}

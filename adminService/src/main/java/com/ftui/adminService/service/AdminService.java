package com.ftui.adminService.service;

import com.ftui.common.vo.BiliResult;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @KafkaListener(topics = "mes",id = "myGroup")
    public  void  listen(ConsumerRecord<?,String> record){
        String value = record.value(); //value的值是你好
        System.out.println(value);
    }

    public BiliResult getKa(){
        return BiliResult.oK();
    }
}

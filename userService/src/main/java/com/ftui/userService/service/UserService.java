package com.ftui.userService.service;

import com.ftui.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class UserService {

    private final CountDownLatch latch = new CountDownLatch(3);

    @Autowired
    KafkaTemplate kafkaTemplate;

    public BiliResult sendMes(String mes){
        kafkaTemplate.send("myTopic", "foo1");
    return  null;
    }

}

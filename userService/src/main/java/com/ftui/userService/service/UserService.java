package com.ftui.userService.service;

import com.ftui.common.vo.BiliResult;
import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class UserService {

    private final CountDownLatch latch = new CountDownLatch(3);

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Autowired
    private KafkaAdmin admin;
    @Autowired
    RedisTemplate redisTemplate;

    public void hello() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("k1", "v1");
        Object k1 = ops.get("k1");
        System.out.println(k1);
    }

    public  UserService(){

    }




    public BiliResult sendMes(String mes){
        kafkaTemplate.send("myTopic", mes);
        hello();
    return  null;
    }

}

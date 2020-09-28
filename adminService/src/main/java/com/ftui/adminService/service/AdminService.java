package com.ftui.adminService.service;

import com.ftui.common.vo.BiliResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    RedisTemplate redisTemplate;


    @Autowired
    KafkaTemplate kafkaTemplate;

    public void hello() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("k1", "v1");
        Object k1 = ops.get("k1");
        System.out.println(k1);
    }
    public BiliResult getKa(){
        hello();
        return BiliResult.oK();
    }

}

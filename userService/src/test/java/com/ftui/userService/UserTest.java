package com.ftui.userService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class UserTest {
    @Autowired
    RedisTemplate redisTemplate=new RedisTemplate();
    @Test
    public void  test(){
        System.out.println("xixi");
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("k1", "v1");
        Map map=new HashMap();
        map.put("22","shazi");
        ops.set("sansan",map);
        Map map2=(Map) ops.get("sansan");
        System.out.println(map2);
    }
    @Test
    public void test2(){
        Penguin penguin=new Penguin();
        String a=penguin.name;
        System.out.println(a);

    }

    public void test3(){
    }

}

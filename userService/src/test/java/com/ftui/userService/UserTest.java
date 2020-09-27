package com.ftui.userService;

import com.ftui.common.pojo.User;
import com.ftui.userService.util.EmailUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class UserTest {

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
    @Test
    public void test3(){
       Penguin penguin=new Penguin();
       penguin.setPenguinName("xixi");
       Method methods[]=penguin.getClass().getMethods();
       for(Method method:methods){
           String name=method.getName();
           if(name.startsWith("get")){

           }else {
               continue;
           }
       }
    }
    @Test
    public void test4(){
      Boolean a=  EmailUtil.isEmail("759646095@qqcom");
        System.out.println(a+"222");
    }
    @Test
    public void test5(){
       // redisTemplate.set
        ValueOperations ops = redisTemplate.opsForValue();
        String json=(String) ops.get("173887745239c22d699-f320-44bc-97fd-1e296b79ed72");

        System.out.println(json);
    }

}

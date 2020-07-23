package com.ftui.userService.service;

import com.ftui.common.pojo.User;
import com.ftui.common.util.PasswordUtil;
import com.ftui.common.vo.BiliResult;
import com.ftui.userService.jpa.Comment;
import com.ftui.userService.jpa.CommentRepository;
import com.ftui.userService.mapper.UserMapper;
import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    private final CountDownLatch latch = new CountDownLatch(3);

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Autowired
    CommentRepository commentRepository;

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

    public BiliResult regist(User user){
        HashMap<String,String>map=PasswordUtil.generate(user.getUserPwd());
        String pwd=map.get("password");
        String salt=map.get("salt");
        user.setUserPwd(pwd);
        user.setUserSalt(salt);
        userMapper.regist(user);
        return BiliResult.oK();
    }

    public BiliResult login(User user){
        String salt=userMapper.getSalt(user.getUserPhone()).get(0);
        String pwd=PasswordUtil.getPwd(user.getUserPwd(),salt);
        user.setUserPwd(pwd);
        ArrayList<User> list=(ArrayList)userMapper.login(user);
        if(list.get(0)!=null){
            return BiliResult.oK();
        }
       else return BiliResult.build(403,"用户名或密码不正确");
    }



    public BiliResult sendMes(String mes){
        kafkaTemplate.send("myTopic1", mes);
        hello();
        Comment comment=commentRepository.findById(1l);
        List<Comment>list=commentRepository.findByContent("ccc");
        System.out.println("zz");
    return  null;
    }

}

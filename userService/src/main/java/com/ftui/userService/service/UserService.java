package com.ftui.userService.service;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.ftui.common.pojo.User;
import com.ftui.common.util.PasswordUtil;
import com.ftui.common.vo.BiliResult;
import com.ftui.userService.config.exception.ContentNotAllowedException;
import com.ftui.userService.jpa.Comment;
import com.ftui.userService.jpa.CommentRepository;
import com.ftui.userService.mapper.UserMapper;
import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Autowired
    RestTemplate restTemplate;

    public void hello() {
        ValueOperations ops = redisTemplate.opsForValue();
        //ops.set("k1", "v1");
        Object k1 = ops.get("k1");
        Map map=new HashMap();
        map.put("22","shazi");
        String mapJSon= JSON.toJSONString(map);
        ops.set("sansan",mapJSon);
        String map1= (String) ops.get("sansan");
        Map map2 = JSON.parseObject(map1,HashMap.class);
        //Map map2=jsonObject.toJavaObject(HashMap.class);
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
//        if (mes==null){
//            throw  new ContentNotAllowedException();
//        }
        kafkaTemplate.send("myTopic1", mes);
        hello();
        Comment comment=commentRepository.findById(1l);
        List<Comment>list=commentRepository.findByContent("ccc");
        System.out.println("zz");
    return  BiliResult.oK();
    }

    public BiliResult sendMesToAdmin(String mes){
        BiliResult res=restTemplate.getForObject("http://localhost:10003/Admin/getKa",BiliResult.class);
        return BiliResult.oK();
    }


}

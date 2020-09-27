package com.ftui.userService.service;
import com.ftui.common.pojo.User;
import com.ftui.common.util.EmailUtil;
import com.ftui.common.util.PasswordUtil;
import com.ftui.common.vo.BiliResult;
import com.ftui.common.vo.VerifyResult;
import com.ftui.userService.jpa.Comment;
import com.ftui.userService.jpa.CommentRepository;
import com.ftui.userService.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.CountDownLatch;
@Slf4j
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
        VerifyResult verifyResult=verifyUser(user);
        if(!verifyResult.getPass()){
            return BiliResult.build(400,verifyResult.getMessage());
        }
        
        user.setUserStatus(1);
        HashMap<String,String>map=PasswordUtil.generate(user.getUserPwd());
        String pwd=map.get("password");
        String salt=map.get("salt");
        user.setUserPwd(pwd);
        user.setUserSalt(salt);
        userMapper.regist(user);
        return BiliResult.oK();
    }

    /**
     * 校验用户的注册信息是否正确
     * @param user
     * @return
     */
    public VerifyResult verifyUser(User user){
        VerifyResult verifyResult=new VerifyResult();
        if(!StringUtils.isNotBlank(user.getUserEmail())){
            verifyResult.setPass(false);
            verifyResult.setMessage("邮箱为空值");
            log.error("邮箱为空值");
            return verifyResult;
        }else if(!StringUtils.isNotBlank(user.getUserName())){
            verifyResult.setPass(false);
            verifyResult.setMessage("用户名为空");
            log.error("用户名为空");
            return verifyResult;
        }else  if(!StringUtils.isNotBlank(user.getUserPhone())){
            verifyResult.setPass(false);
            verifyResult.setMessage("手机号为空");
            log.error("手机号为空");
            return verifyResult;
        }else  if(!StringUtils.isNotBlank(user.getUserPwd())){
            verifyResult.setPass(false);
            verifyResult.setMessage("密码为空");
            log.error("密码为空");
            return verifyResult;
        }else  if(!StringUtils.isNotBlank(user.getVerifyCode())){
            verifyResult.setPass(false);
            verifyResult.setMessage("验证码为空");
            log.error("验证码为空");
            return verifyResult;
        }else  if(!EmailUtil.isEmail(user.getUserEmail())){
            verifyResult.setPass(false);
            verifyResult.setMessage("邮箱格式不正确");
            log.error("邮箱格式不正确");
            return verifyResult;
        }
        verifyResult.setPass(true);
        verifyResult.setMessage("验证通过");
        return verifyResult;
    }


    /**
     * 登录
     * @param user
     * @return
     */
    public BiliResult login(User user){
        String salt=userMapper.getSalt(user.getUserPhone()).get(0);
        String pwd=PasswordUtil.getPwd(user.getUserPwd(),salt);
        user.setUserPwd(pwd);
        ArrayList<User> list=(ArrayList)userMapper.login(user);
        if(list.get(0)!=null){
            HashMap map=saveToken(list.get(0));
            return BiliResult.oK(map);
        }
       else return BiliResult.build(403,"用户名或密码不正确");
    }

    public HashMap saveToken(User user){
        String userJson=JSON.toJSONString(user);
        String token=user.getUserPhone()+ UUID.randomUUID();
        ValueOperations ops=redisTemplate.opsForValue();
        ops.set(token,userJson, 60 * 30);
        //ops.set("name","xiaosan",60*30);
        HashMap map = new HashMap();
        map.put("user", user);
        map.put("token", token);
        return map;
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

    public BiliResult checkTokenTest(String  token){
       ValueOperations ops= redisTemplate.opsForValue();
       Object object=ops.get(token);
       System.out.println(object);
       return BiliResult.oK();
    }

    public BiliResult getUserByToken(HttpServletRequest request){
//        String  token="";
//        Cookie cookies[]=request.getCookies();
//        for (Cookie cookie:cookies){
//            if(cookie.getName().equals("token")){
//                token=cookie.getValue();
//            }
//        }
        System.out.println("xixi");
        //ValueOperations ops= redisTemplate.opsForValue();
        //Object object2=ops.get("name");
        //Object object=ops.get(token);
        User user=new User();
        user.setUserPhone("17399884523");
        return BiliResult.oK(user);
    }

}

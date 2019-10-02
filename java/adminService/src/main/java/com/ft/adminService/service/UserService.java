package com.ft.adminService.service;

import com.ft.adminService.dao.UserMapper;
import com.ft.common.pojo.User;
import com.ft.common.util.EmailUtil;
import com.ft.common.util.JsonUtil;
import com.ft.common.vo.DiliResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Value("${file.dir}")
    private String fileDir;

    @Value("${file.url}")
    private String fileUrl;

    EmailUtil emailUtil=new EmailUtil();

    JsonUtil<User>jsonUtil=new JsonUtil<>();

    Jedis jedis=new Jedis();


    /**
     * 注册的操作
     * @param user
     * @return
     */
    public DiliResult regist(User user){
        String userPwd=DigestUtils.md5Hex(user.getUserPwd());
       user.setUserPwd(userPwd);
       Integer i1=userMapper.insert(user);
       if(i1==0){
           return DiliResult.build(201,"注册失败");
       }
       return DiliResult.oK();
    }

    /**
     * 登录的操作
     * @param user
     * @return
     */
    public DiliResult login(User user){
        user.setUserPwd(DigestUtils.md5Hex(user.getUserPwd()));
        User userResult=userMapper.selectOne(user);
        if(userResult==null){
            return DiliResult.build(201,"登录失败");
        }
        Map map=handleToken(userResult);
        return DiliResult.oK(map);
    }

    public Map handleToken(User user) {
        String token =""+UUID.randomUUID();//token的保留形式为用户邮箱+随机数
        String JsonUser2 = jsonUtil.writeObjToJsonString(user);//转为JSON格式，存储到redis服务器里
        jedis.set(token, JsonUser2);
        jedis.expire(token, 60 * 60 * 24);
        Map map = new HashMap();
        map.put("user", user);
        map.put("token", token);
        return map;
    }

    /**
     * 发送邮箱验证码
     *
     * @param user
     * @return
     */
    public DiliResult sendCode(User user) {
        String userEmail = user.getUserEmail();
        //String verifyCode=RandomUtil.randomVerifyCode(6);
        EmailUtil emailUtil = new EmailUtil();
        String verifyCode = emailUtil.emailCheck(userEmail);
        user.setVerifyCode(verifyCode);
        Integer i1 = userMapper.updateUser(user);
        if (i1 == 0) {
            return DiliResult.build(201, "发送验证码失败");
        }
        return DiliResult.oK();
    }

    /**
     * 通过邮箱验证码登录
     *
     * @param user
     * @return
     */
    public DiliResult loginBycode(User user) {
        User user1 = userMapper.selectOne(user);
        if (user1 == null) {
            return DiliResult.build(201, "登录有误");
        } else {
            Map map = handleToken(user1);
            return DiliResult.oK(map);
        }
    }

    /**
     * 退出登录
     * @param token
     * @return
     */
    public DiliResult logout(String token) {
        jedis.del(token);
        return DiliResult.oK();
    }

    /**
     * 通过验证码修改用户信息
     * @param user
     * @return
     */
    public DiliResult updateUserByCode(User user) {
        String userPwd = DigestUtils.md5Hex(user.getUserPwd());
        user.setUserPwd(userPwd);
        Integer i1 = userMapper.updateUserByCode(user);
        if (i1 == 0) {
            return DiliResult.build(201, "修改失败");
        }
        return DiliResult.oK();
    }

    /**
     * 更改用户信息
     */
    public DiliResult updateUser(User user) {
        String userPwd = DigestUtils.md5Hex(user.getUserPwd());
        user.setUserPwd(userPwd);
        Integer i1 = userMapper.updateUser(user);
        if (i1 == 0) {
            return DiliResult.build(201, "更新失败");
        }
        User user1 = new User();
        user1.setId(user.getId());
        User userResult = userMapper.selectOne(user1);
        Map map = handleToken(userResult);
        return DiliResult.oK(map);
    }


}

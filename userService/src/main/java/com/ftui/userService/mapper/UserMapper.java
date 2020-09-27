package com.ftui.userService.mapper;

import com.ftui.common.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public void  regist(User user);
    /**
     * 登录
     * @param user
     * @return
     */
    public List<User> login(User user);
    /**
     * 获取盐值
     * @param userPhone
     */
    public List<String> getSalt(String userPhone);

}

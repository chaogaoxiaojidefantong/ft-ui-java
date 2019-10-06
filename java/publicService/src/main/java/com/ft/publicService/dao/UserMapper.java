package com.ft.publicService.dao;

import com.ft.common.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface UserMapper extends Mapper<User> {
    public Integer updateUser(User user);
    public Integer updateUserByCode(User user);
}

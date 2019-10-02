package com.ft.adminService.dao;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import com.ft.common.pojo.User;
@Repository
public interface UserMapper extends Mapper<User> {
public Integer updateUser(User user);
public Integer updateUserByCode(User user);
}

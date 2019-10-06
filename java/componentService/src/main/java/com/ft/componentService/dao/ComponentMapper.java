package com.ft.componentService.dao;

import com.ft.common.pojo.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ComponentMapper extends Mapper<Component> {
}

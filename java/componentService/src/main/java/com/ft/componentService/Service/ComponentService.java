package com.ft.componentService.Service;

import com.ft.common.pojo.Component;
import com.ft.common.vo.DiliResult;
import com.ft.componentService.dao.ComponentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {

    @Autowired
    ComponentMapper componentMapper;

    public DiliResult selectAll(){
        List<Component> list=componentMapper.selectAll();
        return DiliResult.oK(list);
    }
}

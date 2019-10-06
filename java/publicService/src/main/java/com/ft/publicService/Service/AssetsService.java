package com.ft.publicService.Service;

import com.ft.common.pojo.Assets;
import com.ft.common.vo.DiliResult;
import com.ft.publicService.dao.AssetsMapper;
import com.ft.publicService.webSocket.EchoEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpointConfig;
import java.util.List;

@Service
public class AssetsService {

    @Autowired
    AssetsMapper assetsMapper;



    @Value("${file.dir}")
    private String fileDir;

    @Value("${file.url}")
    private String fileUrl;



    //返回所有的assets对象
    public DiliResult selectAll(){
        List<Assets> list=assetsMapper.selectAll();
        ServerEndpointConfig.Builder.create(EchoEndpoint.class, "/echo").build();
        return DiliResult.oK(list);
    }

    public DiliResult startSocket(){
        return null;
    }

}

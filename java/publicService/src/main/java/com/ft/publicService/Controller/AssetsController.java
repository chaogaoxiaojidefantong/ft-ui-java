package com.ft.publicService.Controller;
import com.ft.common.vo.DiliResult;
import com.ft.publicService.Service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Assets/")
public class AssetsController {

    @Autowired
    AssetsService assetsService;


    @RequestMapping("selectAll")
    public DiliResult selectAll(){
        return assetsService.selectAll();
    }

}

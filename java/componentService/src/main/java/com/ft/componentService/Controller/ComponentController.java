package com.ft.componentService.Controller;
import com.ft.common.vo.DiliResult;
import com.ft.componentService.Service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Component/")
public class ComponentController {

    @Autowired
    ComponentService componentService;

    @RequestMapping("selectAll")
    public DiliResult selectAll(){
        return componentService.selectAll();
    }
}

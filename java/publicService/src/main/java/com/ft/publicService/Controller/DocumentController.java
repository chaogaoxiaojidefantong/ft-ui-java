package com.ft.publicService.Controller;

import com.ft.common.vo.DiliResult;
import com.ft.publicService.Service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User/")
public class DocumentController {
    @Autowired
    DocumentService documentService;
    public DiliResult getDocment(String name){
          return   documentService.getDocument(name);
    }
}

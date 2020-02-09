package com.ft.publicService.Service;

import com.ft.common.vo.DiliResult;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
public DiliResult getDocument(String name){
    return DiliResult.oK();
}
}

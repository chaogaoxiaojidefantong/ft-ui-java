package com.ftui.common.vo;

import lombok.Data;

@Data
public class VerifyResult {
    /**
     * 是否通过校验
     */
    private Boolean pass;
    private String message;
}

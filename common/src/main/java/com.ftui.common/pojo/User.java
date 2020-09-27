package com.ftui.common.pojo;

import lombok.Data;

@Data
public class User {
    private Long userId;

    private String userPhone;

    private String userPwd;

    private String userEmail;

    private Integer userStatus;

    private String userName;

    private String verifyCode;

    private String userSalt;

    public String getUserName() {
        return userName;
    }
}

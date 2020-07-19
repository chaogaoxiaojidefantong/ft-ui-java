package com.ftui.common.util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PasswordUtil {
    public static String genetateSalt(){
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        String salt = sb.toString();
        return salt;
    }

    public static void main(String[] args) {
       String a= genetateSalt();
       String b=genetateSalt();
       System.out.println(a);
    }

    /**
     * 生成含有随机盐的密码
     */
    public static HashMap<String, String> generate(String password) {
        String salt=genetateSalt();
        password = md5Hex(password + salt);
        HashMap<String,String> map=new HashMap();
        map.put("password",password);
        map.put("salt",salt);
        return map;
    }

    /**
     * 校验密码是否正确
     */
    public static String getPwd(String password,String  salt) {
        password = md5Hex(password + salt);
        return password;
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }
}

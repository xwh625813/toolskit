package com.security.toolskit.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
@Component
public class MD5Util {
    //MD5加密
    public static String md5(String password) {
        return DigestUtils.md5Hex(password);
    }
    //明文密码和固定salt生成MD5，用于用户传输到服务器的时候加密，使得传输的密码不是明文密码
    private static final String salt="sakura";
    public static String formEncryption(String password) {
        String str=salt.charAt(5)+salt.charAt(2)+password+salt.charAt(0);
        return md5(str);
    }
    //第一次MD5的密码和随机salt生成的MD5,用于存储到数据库密码的加密
    public static String dbEncryption(String password,String salt) {
        String str=salt.charAt(0)+salt.charAt(2)+password+salt.charAt(5);
        return md5(str);
    }

    public static void main(String[] args) {
        System.out.println(formEncryption("123456"));
    }

}
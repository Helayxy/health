package com.itheima.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * BCrypt加密工具类
 *
 * @author Helay
 * @date 2020/2/19 18:25
 */
public class BCryptUtils {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //对原密码进行加密
        String pwd = encoder.encode("root");
        System.out.println(pwd);
    }
}

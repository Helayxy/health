package com.itheima.service;

import com.itheima.pojo.User;

/**
 * @author Helay
 * @date 2020/2/17 20:44
 */
public interface UserService {

    //根据用户名查询用户信息
    User findByUsername(String username);
}

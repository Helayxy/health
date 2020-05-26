package com.itheima.dao;

import com.itheima.pojo.User;

/**
 * @author Helay
 * @date 2020/2/17 21:16
 */
public interface UserDao {

    //根据用户名查询用户基本信息
    User findByUsername(String username);
}

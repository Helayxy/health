package com.itheima.dao;

import com.itheima.pojo.Role;

import java.util.Set;

/**
 * @author Helay
 * @date 2020/2/17 21:20
 */
public interface RoleDao {

    //根据用户id查询用户对应的角色集合
    Set<Role> findByUserId(int id);
}

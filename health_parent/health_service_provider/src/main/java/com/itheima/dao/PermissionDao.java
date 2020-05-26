package com.itheima.dao;

import com.itheima.pojo.Permission;

import java.util.Set;

/**
 * @author Helay
 * @date 2020/2/17 21:23
 */
public interface PermissionDao {

    //根据角色id查询该角色对应的权限集合
    Set<Permission> findByRoleId(int roleId);
}

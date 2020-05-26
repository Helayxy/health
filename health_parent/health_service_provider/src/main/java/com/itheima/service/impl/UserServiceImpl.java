package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.PermissionDao;
import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.pojo.Permission;
import com.itheima.pojo.Role;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author Helay
 * @date 2020/2/17 21:15
 */
@Service(interfaceClass = UserService.class)
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);//通过用户名查询用户基本信息
        if (user == null) {
            return null;
        }
        Integer userId = user.getId();
        Set<Role> roles = roleDao.findByUserId(userId);//根据用户id查询用户对应的角色集合
        if (roles != null && roles.size() > 0) {
            for (Role role : roles) {
                Integer roleId = role.getId();
                //set集合不允许存放重复的元素（==或equals为true）
                // 一个用户可能对应多个角色，对个角色之间可能会有相同的权限，使用set集合就是为了去除重复权限
                Set<Permission> permissions = permissionDao.findByRoleId(roleId);//根据角色id查询该角色对应的权限集合
                if (permissions != null && permissions.size() > 0) {
                    role.setPermissions(permissions);//为该角色设置权限
                }
            }
            user.setRoles(roles);//为该用户设置角色
        }
        return user;
    }
}

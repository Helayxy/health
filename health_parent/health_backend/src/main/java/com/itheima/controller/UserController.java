package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Helay
 * @date 2020/2/19 17:53
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 获得当前登录用户的用户名
     *
     * @return
     */
    @RequestMapping("/getUsername")
    public Result getUsername() {
        //当Spring security框架完成用户认证后，会将当前用户的信息保存至框架提供的上下文对象
        //框架底层基于session实现
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != null) {
            String username = user.getUsername();
            return new Result(true, MessageConstant.GET_USERNAME_SUCCESS, username);
        }
        return new Result(false, MessageConstant.GET_USERNAME_FAIL);
    }
}

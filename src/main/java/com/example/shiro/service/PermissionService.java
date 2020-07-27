package com.example.shiro.service;

import com.example.shiro.entity.User;

/**
 * @program: shiro
 * @description:
 * @author: yetin
 * @create: 2020-07-27 10:42
 **/

public interface PermissionService {


    /**
     * 获取全部用户信息，包括角色，权限
     *
     * @param username
     * @return
     */
    User findAllUserInfoByUsername(String username);


    /**
     * 获取用户基本信息
     *
     * @param userId
     * @return
     */
    User findSimpleUserInfoById(int userId);


    /**
     * 根据用户名查找用户信息
     *
     * @param username
     * @return
     */
    User findSimpleUserInfoByUsername(String username);


}

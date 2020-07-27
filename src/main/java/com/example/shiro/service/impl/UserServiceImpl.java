package com.example.shiro.service.impl;

import com.example.shiro.entity.Role;
import com.example.shiro.mapper.RoleMapper;
import com.example.shiro.mapper.UserMapper;
import com.example.shiro.entity.User;
import com.example.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: shiro
 * @description:
 * @author: yetin
 * @create: 2020-07-27 10:43
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User findAllUserInfoByUsername(String username) {
        User user = userMapper.findByUsername(username);
        List<Role> roles = roleMapper.findRoleByUserId(user.getId());
        user.setRoleList(roles);
        return user;
    }

    @Override
    public User findSimpleUserInfoById(int userId) {
        User user = userMapper.findById(userId);
        return user;
    }

    @Override
    public User findSimpleUserInfoByUsername(String username,String password) {
        User user = userMapper.findByUsernameAndPassword(username,password);
        return user;
    }
}

package com.example.shiro;

import com.example.shiro.entity.Role;
import com.example.shiro.mapper.RoleMapper;
import com.example.shiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @program: shiro
 * @description:
 * @author: h2o
 * @create: 2020-07-26 14:38
 **/
@Slf4j
@SpringBootTest
public class QuickstartTestDB {

    @Autowired
    private UserService userService;


    @BeforeEach
    public void init() {

    }

    @Autowired
    private RoleMapper roleMapper;


    @Test
    public void testAuthentication() {

        List<Role> roles = roleMapper.findRoleByUserId(3);
        log.info(String.valueOf(roles));

//        User jack = userService.findAllUserInfoByUsername("jack");
//        jack.getRoleList().get(0).;
//        log.info(String.valueOf(jack));


//        User simpleUserInfoById = userService.findSimpleUserInfoById(2);
//        log.info(String.valueOf(simpleUserInfoById));
//
//
//        User simpleUserInfoByUsername = userService.findSimpleUserInfoByUsername("二当家小D","123456");
//        log.info(String.valueOf(simpleUserInfoByUsername));


    }
}

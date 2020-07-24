package com.example.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: shiro
 * @description:
 * @author: yetin
 * @create: 2020-07-24 11:38
 **/
@SpringBootTest
@Slf4j
public class QuickStartTest3 {


    @BeforeEach
    public void init() {

    }

    @Test
    public void testAuthentication() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("wang", "123");
        subject.login(usernamePasswordToken);
        log.info(String.valueOf(subject.isPermitted("usera")));
    }
}

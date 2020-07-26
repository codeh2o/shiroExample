package com.example.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @program: shiro
 * @description:
 * @author: h2o
 * @create: 2020-07-26 14:38
 **/
@Slf4j
public class QuickstartTest5 {
    private CustomRealm customRealm = new CustomRealm();
    private DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
    @BeforeEach
    public void init(){
        defaultSecurityManager.setRealm(customRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
    }

    @Test

    public void testAuthentication(){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack", "123");
        subject.login(usernamePasswordToken);
        log.info(String.valueOf(subject.isAuthenticated()));
        System.out.println("是否有对应的角色:"+subject.hasRole("role1"));
    }
}

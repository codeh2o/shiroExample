package com.example.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
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
public class QuickStartTest2 {

    private DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
    private SimpleAccountRealm accountRealm = new SimpleAccountRealm();
    @BeforeEach
    public  void init(){
        accountRealm.addAccount("admin","123456","root","admin");
        accountRealm.addAccount("ytlreal","111111","user");
        defaultSecurityManager.setRealm(accountRealm);

    }

    @Test
    public void testAuthentication(){
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("admin","123456");
        subject.login(usernamePasswordToken);

        log.info(String.valueOf(subject.hasRole("admin")));

    }
}

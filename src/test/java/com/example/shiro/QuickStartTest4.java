package com.example.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

/**
 * @program: shiro
 * @description:
 * @author: yetin
 * @create: 2020-07-24 11:38
 **/
@SpringBootTest
@Slf4j
public class QuickStartTest4 {
    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;
    @BeforeEach
    public void init() {

    }

    @Test
    public void testAuthentication() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:jdbcRealm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack", "123");
        subject.login(usernamePasswordToken);
        subject.checkRole("role3");
        log.info(String.valueOf(subject.isPermitted("usera")));
    }

    @Test
    public void testAuthentication2() {

        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);
        securityManager.setRealm(jdbcRealm);

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack", "123");
        subject.login(usernamePasswordToken);
        subject.checkRole("role1");
        log.info(String.valueOf(subject.isPermitted("usera")));
    }
}

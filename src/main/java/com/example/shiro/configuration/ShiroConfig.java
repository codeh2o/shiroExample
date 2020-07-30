package com.example.shiro.configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: shiro
 * @description:
 * @author: h2o
 * @create: 2020-07-27 23:45
 **/
@Configuration
@Slf4j
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //需要登录的接口，如果访问某个接口，需要登录却没登录，则调用此接口(如果不是前后端分离，则跳转页面)
        shiroFilterFactoryBean.setLoginUrl("/pub/need_login");

        //登录成功，跳转url，如果前后端分离，则没这个调用
        //shiroFilterFactoryBean.setSuccessUrl("/");

        //没有权限，未授权就会调用此方法， 先验证登录-》再验证是否有权限
        shiroFilterFactoryBean.setUnauthorizedUrl("/pub/not_permit");

        //设置自定义filter
        Map<String, Filter> filterMap= new LinkedHashMap<>();
        filterMap.put("anyRoles",new AnyRolesAuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        //坑1
        //配置过滤器
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        filterChainDefinitionMap.put("/logout","logout");
        filterChainDefinitionMap.put("/pub/**","anon");
        filterChainDefinitionMap.put("/auth/**","user");
        //filterChainDefinitionMap.put("/admin/**","roles[admin]");
        filterChainDefinitionMap.put("/admin/**","anyRoles[admin,editor]");
        filterChainDefinitionMap.put("/video/update","perms[video_update]");
        filterChainDefinitionMap.put("/**","user");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setSessionManager(sessionManager());


        defaultWebSecurityManager.setRealm(customRealm());
        return defaultWebSecurityManager;
    }

    @Bean
    public SessionManager sessionManager(){
        CustomSessionManager customSessionManager = new CustomSessionManager();

        return customSessionManager;
    }

    @Bean//疑惑
    public CustomRealm customRealm(){
        CustomRealm customRealm = new CustomRealm();
        //customRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return customRealm;
    }



    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);

        return hashedCredentialsMatcher;
    }
}

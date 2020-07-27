package com.example.shiro.configuration;

import com.example.shiro.entity.Role;
import com.example.shiro.entity.User;
import com.example.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: shiro
 * @description:
 * @author: h2o
 * @create: 2020-07-26 21:30
 **/
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        List<String> stringRoleList = new ArrayList<>();
        List<String> stringPermissionList = new ArrayList<>();

        User allUserInfoByUsername = userService.findAllUserInfoByUsername(username);
        if(allUserInfoByUsername ==null){
            return null;
        }
        List<Role> roleList = allUserInfoByUsername.getRoleList();

        stringRoleList = roleList.stream().map(role -> role.getName()).collect(Collectors.toCollection(ArrayList::new));

        roleList.stream().forEach(role -> {
            role.getPermissionList().forEach(permission -> {
                stringPermissionList.add(permission.getName());

            });
        });

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(stringRoleList);
        simpleAuthorizationInfo.addStringPermissions(stringPermissionList);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User allUserInfoByUsername = userService.findAllUserInfoByUsername(username);
        String password = allUserInfoByUsername.getPassword();
        if(password==null||password==""){
            return null;
        }
        return new SimpleAuthenticationInfo(username,password,this.getClass().getName());
    }
}

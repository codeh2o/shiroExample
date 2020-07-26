package com.example.shiro.dao;

import com.example.shiro.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: shiro
 * @description:
 * @author: h2o
 * @create: 2020-07-26 21:59
 **/
@Repository
public interface PermissionMapper {

    @Select("")
    public List<Role> findPermissionListByRoleId(@Param("roleId") int roleId);
}

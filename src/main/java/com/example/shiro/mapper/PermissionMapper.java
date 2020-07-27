package com.example.shiro.mapper;

import com.example.shiro.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: shiro
 * @description:
 * @author: h2o
 * @create: 2020-07-26 21:59
 **/
@Mapper
@Repository
public interface PermissionMapper {
    //public List<Role> findPermissionListByRoleId(@Param("roleId") int roleId);
    Permission load(@Param("id") int permissionId);
}

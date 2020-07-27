package com.example.shiro.mapper;

import com.example.shiro.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: shiro
 * @description:
 * @author: h2o
 * @create: 2020-07-26 21:55
 **/
@Mapper
@Repository
public interface RoleMapper {

    List<Role> findRoleByUserId(@Param("userId") int userId);
}

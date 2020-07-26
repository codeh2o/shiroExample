package com.example.shiro.dao;

import com.example.shiro.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @program: shiro
 * @description:
 * @author: h2o
 * @create: 2020-07-26 21:48
 **/
@Repository
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    public User findByUsername(@Param("username") String username);

    @Select("select * from user where username = #{userId}")
    public User findById(@Param("userId") int id);

    @Select("select * from user where username = #{username} and password = #{password}")
    public User findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}

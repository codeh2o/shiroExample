package com.example.shiro.mapper;

import com.example.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: shiro
 * @description:
 * @author: h2o
 * @create: 2020-07-26 21:48
 **/
@Mapper
@Repository
public interface UserMapper {


    public User findByUsername(@Param("username") String username);


    public User findById(int id);

    public User findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}

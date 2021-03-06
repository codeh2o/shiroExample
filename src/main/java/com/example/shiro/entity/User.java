package com.example.shiro.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @program: shiro
 * @description:
 * @author: h2o
 * @create: 2020-07-26 21:38
 **/
@Getter
@Setter
@ToString
public class User {
    private int id;
    private String username;
    private String password;

    private List<Role> roleList;
}

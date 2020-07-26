package com.example.shiro.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @program: shiro
 * @description:
 * @author: h2o
 * @create: 2020-07-26 21:43
 **/
@Getter
@Setter
public class Role {
    private int id;
    private String name;
    private String description;

    private List<Permission> roleList;
}

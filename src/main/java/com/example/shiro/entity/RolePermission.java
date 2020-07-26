package com.example.shiro.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: shiro
 * @description:
 * @author: h2o
 * @create: 2020-07-26 21:46
 **/
@Getter
@Setter
public class RolePermission {
    private int id;
    private int roleId;
    private int permissionId;
}

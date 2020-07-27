package com.example.shiro.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: shiro
 * @description:
 * @author: h2o
 * @create: 2020-07-26 21:43
 **/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Role {
    private Integer id;
    private String name;
    private String description;

    private List<Permission> permissionList = new ArrayList<>();
}

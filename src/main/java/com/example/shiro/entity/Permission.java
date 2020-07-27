package com.example.shiro.entity;

import lombok.*;

/**
 * @program: shiro
 * @description:
 * @author: h2o
 * @create: 2020-07-26 21:42
 **/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Permission {
    private int id;
    private String name;
    private String url;

}

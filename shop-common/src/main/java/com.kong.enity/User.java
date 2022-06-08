package com.kong.enity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="shop_user")
@Data
public class User{
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    //姓名
    private String username;
    //密码
    private String password;
    //手机号
    private String telephone;
}
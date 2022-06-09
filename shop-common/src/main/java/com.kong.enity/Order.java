package com.kong.enity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "shop_order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    //用户ID
    private Integer uid;
    //用户名
    private String username;

    private Integer pid;

    private String pname;

    private Double pprice;

    private Integer number;
}

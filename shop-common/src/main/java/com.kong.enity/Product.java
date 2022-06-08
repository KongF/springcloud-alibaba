package com.kong.enity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//商品
@Entity(name="shop_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    private String pname;
    //价格
    private Double pprice;
    //库存
    private Integer stock;
}

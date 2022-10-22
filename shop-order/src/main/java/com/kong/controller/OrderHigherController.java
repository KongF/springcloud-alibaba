package com.kong.controller;

import com.alibaba.fastjson.JSON;
import com.kong.enity.Order;
import com.kong.enity.Product;
import com.kong.service.OrderService;
import com.kong.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderHigherController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid")Integer pid){
        log.info("接收到{}号商品下单请求",pid);
        Product product = productService.findByPid(pid);
        log.info("查询到{}号商品的信息：{}",pid, JSON.toJSONString(product));
        //模拟网络延迟
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Order order = new Order();
        order.setUid(1);
        order.setUsername("张三");
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        log.info("订单信息{}",JSON.toJSONString(order));
        return order;
    }
    @RequestMapping("/order/message")
    public String message(){
        return "高并发测试";
    }
    @RequestMapping("/order/message1")
    public String message1(){
        return "高并发测试1";
    }
    @RequestMapping("/order/message2")
    public String message2(){
        return "高并发测试2";
    }
}

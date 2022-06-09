package com.kong.controller;

import com.kong.enity.Order;
import com.kong.enity.Product;
import com.kong.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;
@GetMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid")Integer pid){
        log.info(">>客户下单，调用商品微服务查询商品信息");
        Product product = restTemplate.getForObject("http://localhost:8081/product/"+pid,Product.class);
        Order order = new Order();
        order.setUid(1);
        order.setUsername(product.getPname());
        return order;
    }
}

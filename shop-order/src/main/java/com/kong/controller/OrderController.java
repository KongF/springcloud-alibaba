package com.kong.controller;

import com.kong.enity.Order;
import com.kong.enity.Product;
import com.kong.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid")Integer pid){
        log.info(">>客户下单，调用商品微服务查询商品信息");
//        //nacos 中获取服务地址
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
////        ServiceInstance serviceInstance = discoveryClient.getInstances("service-product").get(0);
//        int index = new Random().nextInt(instances.size());
//        ServiceInstance serviceInstance = instances.get(index);
//        String url = serviceInstance.getHost()+":"+serviceInstance.getPort();
//        log.info("nacos中获取的url:"+url);
        String url = "service-product";
        Product product = restTemplate.getForObject("http://"+url+"/product/"+pid,Product.class);

        Order order = new Order();
        order.setUid(1);
        order.setUsername(product.getPname());
        order.setPid(product.getPid());
        order.setNumber(1);
        order.setPname(product.getPname());
        orderService.save(order);
        return order;
    }
}

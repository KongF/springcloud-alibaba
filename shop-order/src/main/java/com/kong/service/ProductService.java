package com.kong.service;

import com.kong.enity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("service-product")
public interface ProductService {
    @GetMapping(value = "/product/{pid}")
    Product findByPid(@PathVariable("pid")Integer pid);
}

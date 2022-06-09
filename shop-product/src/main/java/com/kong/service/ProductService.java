package com.kong.service;

import com.kong.enity.Product;

public interface ProductService {
    Product findByPid(Integer pid);
}

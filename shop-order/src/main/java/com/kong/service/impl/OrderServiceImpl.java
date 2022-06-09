package com.kong.service.impl;

import com.kong.dao.OrderDao;
import com.kong.enity.Order;
import com.kong.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public void save(Order order) {
        orderDao.save(order);
    }
}

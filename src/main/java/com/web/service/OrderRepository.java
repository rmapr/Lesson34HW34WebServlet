package com.web.service;

import com.web.dto.Order;
import com.web.dto.Product;

import java.util.Collection;
import java.util.List;


public interface OrderRepository {
    Order getOrder(Integer id);
    List<Order> getAllOrders();
    boolean addOrder(List<Product> product);
}

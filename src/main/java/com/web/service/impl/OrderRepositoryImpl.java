package com.web.service.impl;

import com.web.dto.Order;
import com.web.dto.Product;
import com.web.exception.OrderNotFoundException;
import com.web.service.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
@Slf4j
public class OrderRepositoryImpl implements OrderRepository {
    private List<Order> orderList;

    public OrderRepositoryImpl() {
        orderList = new ArrayList<>();
    }

    @Override
    public Order getOrder(Integer id) {
        for (Order order : orderList) {
            if (order.getId().equals(id)) return order;
        }
        log.info("Id not found...");
        throw new OrderNotFoundException("Id not found");
    }

    @Override
    public List<Order> getAllOrders() {
        return orderList;
    }

    @Override
    public boolean addOrder(List<Product> products) {
        Order order = new Order();
        order.setDate(new Timestamp(System.currentTimeMillis()));
        order.setProducts(products);
        order.setCost(order.getProducts().stream().mapToDouble(Product::getCost).sum());
        return orderList.add(order);
    }

    @Override
    public void updateOrder(Integer id, List<Product> products) {
        Order order = getOrder(id);
        order.setDate(new Timestamp(System.currentTimeMillis()));
        order.setProducts(products);
        order.setCost(order.getProducts().stream().mapToDouble(Product::getCost).sum());
    }

    @Override
    public void deleteOrder(Integer id) {
        Order order = getOrder(id);
        if (!orderList.remove(order)) {
            log.info("Id for Delete not found...");
            throw new OrderNotFoundException("Id not found");
        }
    }
}

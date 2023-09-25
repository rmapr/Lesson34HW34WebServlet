package com.web.controller;

import com.web.dto.Order;
import com.web.dto.Product;
import com.web.service.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderRepository orderRepository;

    @GetMapping("/{id}")
    public Order getOrderController(@PathVariable("id") Integer id) {
        log.info("call method get from Order by Id...");
        return orderRepository.getOrder(id);
    }

    @GetMapping("/all")
    public List<Order> getAllOrdersController() {
        log.info("call method get all Orders...");
        return orderRepository.getAllOrders();
    }

    @PostMapping("")
    public boolean addOrderController(@RequestBody List<Product> products) {
        log.info("call method add order...");
        products.forEach(product -> log.info("Add product: " + product.getName() + " " + product.getCost()));
        return orderRepository.addOrder(products);
    }
    @PutMapping("/update/{id}")
    public void updateOrderController(@PathVariable Integer id, @RequestBody List<Product> products) {
        Order updateOrder = orderRepository.getOrder(id);
        log.info("call method Update order...");
        products.forEach(product -> log.info("Update product: " + product.getName() + " " + product.getCost()));
        orderRepository.updateOrder(id, products);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteOrderController(@PathVariable("id") final Integer id) {
        log.info("call method Delete order...");
        log.info("Delete order: " + id);
        orderRepository.deleteOrder(id);
    }

}

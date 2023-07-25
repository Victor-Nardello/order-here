package br.com.orderhere.controller;

import br.com.orderhere.domain.OrderDomain;
import br.com.orderhere.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping(value = "/orders")
    public OrderDomain getOrders() {
        return orderRepository.getOrders();
    }
}
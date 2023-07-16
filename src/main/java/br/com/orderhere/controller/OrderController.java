package br.com.orderhere.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping(value = "/orders")
    public String getOrders() {
        return "Opaaa :D";
    }
}
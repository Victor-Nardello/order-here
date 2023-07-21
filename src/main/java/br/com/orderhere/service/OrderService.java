package br.com.orderhere.service;

import br.com.orderhere.domain.OrderDomain;
import br.com.orderhere.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class OrderService extends OrderRepository {

    @Autowired
    GenerateService generateService;

    @Override
    public OrderDomain getOrders() {
        return createNewOrder();
    }

    protected OrderDomain createNewOrder() {
        final LocalDateTime date = LocalDateTime.now();
        OrderDomain orderDomain = new OrderDomain();

        try {
            orderDomain.setOrderDate(date);
            orderDomain.setOrderId(UUID.randomUUID().toString());
            orderDomain.setClientInformations(generateService.generateClientInformations());
            orderDomain.setDescription(generateService.generateDescription());
            orderDomain.setOrderPrice(generateService.generateOrderPrice());

            BigDecimal clientMoney = orderDomain.getClientInformations().getMoney();
            BigDecimal orderPrice = orderDomain.getOrderPrice();

            if(clientMoney.longValue() > orderPrice.longValue()) {
                BigDecimal calculateCashback = clientMoney.subtract(orderPrice);
                orderDomain.setCashback(calculateCashback);
            } else {
                orderDomain.setDescription("No cash to the order");
                orderDomain.setCashback(BigDecimal.ZERO);
            }
       } catch (Exception e) {
           log.error("Error to order create", new Exception());
       }
        return orderDomain;
    }
}
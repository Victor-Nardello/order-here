package br.com.orderhere.service;

import br.com.orderhere.domain.OrderDomain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    GenerateService generateServiceMock;

    @InjectMocks
    OrderService orderService;

    @Test
    public void createNewOrderTest() {
        final LocalDateTime date = LocalDateTime.now();
        OrderService orderService = new OrderService();
        GenerateService generateService = new GenerateService();

        OrderDomain order = orderService.createNewOrder();
        order.setOrderId(UUID.randomUUID().toString());
        order.setOrderDate(date);
        order.setClientInformations(generateService.generateClientInformations());
        order.setDescription(generateService.generateDescription());
        order.setOrderPrice(generateService.generateOrderPrice());

        assertNotNull(order);
        assertNotNull(order.getOrderId());
        assertNotNull(order.getOrderDate());
        assertNotNull(order.getClientInformations());
        assertNotNull(order.getDescription());
        assertNotNull(order.getOrderPrice());
    }
}
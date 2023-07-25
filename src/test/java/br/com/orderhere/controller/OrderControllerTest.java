package br.com.orderhere.controller;

import br.com.orderhere.domain.OrderDomain;
import br.com.orderhere.repository.OrderRepository;
import br.com.orderhere.service.GenerateService;
import br.com.orderhere.service.OrderService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebMvcTest(OrderController.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderControllerTest {
    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderRepository orderRepository;

    @BeforeEach
    public void setup() {
        mockMvc = standaloneSetup(orderController).build();
    }

    @Test
    public void getOrdersHttp200Test() throws Exception {
        final LocalDateTime date = LocalDateTime.now();
        GenerateService generateService = new GenerateService();

        OrderDomain order = new OrderDomain();
        order.setOrderId(UUID.randomUUID().toString());
        order.setOrderDate(LocalDateTime.now());
        order.setOrderId(UUID.randomUUID().toString());
        order.setOrderDate(date);
        order.setClientInformations(generateService.generateClientInformations());
        order.setDescription(generateService.generateDescription());
        order.setOrderPrice(generateService.generateOrderPrice());

        when(orderService.getOrders()).thenReturn(order);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/orders");
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();
    }

    public void getOrdersHttp404Test() throws Exception {
        final LocalDateTime date = LocalDateTime.now();
        GenerateService generateService = new GenerateService();

        OrderDomain order = new OrderDomain();
        order.setOrderId(UUID.randomUUID().toString());
        order.setOrderDate(LocalDateTime.now());
        order.setOrderId(UUID.randomUUID().toString());
        order.setOrderDate(date);
        order.setClientInformations(generateService.generateClientInformations());
        order.setDescription(generateService.generateDescription());
        order.setOrderPrice(generateService.generateOrderPrice());

        when(orderService.getOrders()).thenReturn(order);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/orders");
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().is4xxClientError())
                .andReturn();
    }
}
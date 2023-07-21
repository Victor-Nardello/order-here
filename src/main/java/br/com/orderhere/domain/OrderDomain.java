package br.com.orderhere.domain;

import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDomain {
    @Id
    private String orderId;
    private LocalDateTime orderDate;
    private String description;
    private BigDecimal orderPrice;
    private BigDecimal cashback;
    private ClientOrderDomain clientInformations;
}
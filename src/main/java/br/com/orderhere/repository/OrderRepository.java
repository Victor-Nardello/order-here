package br.com.orderhere.repository;

import br.com.orderhere.domain.OrderDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class OrderRepository{
    public abstract OrderDomain getOrders();
}

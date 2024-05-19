package com.example.shoppingmall.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class OrderRepository {
    Map<Integer, Order> orderTable = new HashMap<>();
    private int orderId = 0;

    public void saveOrder(Order order) {
        log.info("productName = {}", order.getProduct().getName());
        log.info("count = {}", order.getCount());

        order.setId(orderId++);
        orderTable.put(order.getId(), order);
    }
}

package com.example.shoppingmall.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderService {
    private OrderRepository orderRepository;

    public void orderProduct(Order order) {
        orderRepository.saveOrder(order);
    }
}

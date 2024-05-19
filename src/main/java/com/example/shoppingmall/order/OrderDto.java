package com.example.shoppingmall.order;

import lombok.Getter;

@Getter
public class OrderDto {
    private int productId;
    private int count;

//    public OrderDto() {
//        // Default constructor
//    }
//    public OrderDto(Order order) {
//        productId = order.getProduct().getId();
//        count = order.getCount();
//    }
}

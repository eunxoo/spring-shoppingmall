package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import lombok.Getter;

@Getter
public class Order {
    private int id;
    private Product product; // Domain = Object
    private int count;

    public Order(Product orderedProduct, int count) {
        this.product = orderedProduct;
        this.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }
}

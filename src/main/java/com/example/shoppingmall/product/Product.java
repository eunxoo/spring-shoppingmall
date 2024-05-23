package com.example.shoppingmall.product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private int id;
    private String name;
    private int price;
    private String description;
    private String img;
    private int categoryId;
    // TODO setter는 DTO 등장하고 지우러 오자!!


    public Product(String name, int price, String description, String img, int categoryId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.img = img;
        this.categoryId = categoryId;
    }
}


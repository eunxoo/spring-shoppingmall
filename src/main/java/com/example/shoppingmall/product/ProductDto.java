package com.example.shoppingmall.product;

import com.example.shoppingmall.member.Member;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ProductDto {
    private int id;
    @NotBlank(message = "name은 필수입니다.")
    private String name;

    @NotNull(message = "price은 필수 항목입니다.")
    @Min(value = 0, message = "제품 가격은 0 이상이어야 합니다.")
    private Integer price;
    private String description;
    private String img;
    private int categoryId;

    public Product convertToEntity(){
        return new Product(name, price, description, img, categoryId);
    }
}

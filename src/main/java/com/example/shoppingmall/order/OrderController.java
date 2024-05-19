package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import com.example.shoppingmall.product.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class OrderController {

    private OrderService orderService;
    private ProductService productService;

    @PostMapping("/orders")
    public void orderProduct(@RequestBody OrderDto orderDto){
        Product orderedProduct = productService.findProduct(orderDto.getProductId());

        // TODO : Service로 이사 갈 거예요 DTO -> Entity
        Order requestOrder = new Order(orderedProduct, orderDto.getCount());

        orderService.orderProduct(requestOrder);
    }
}

package com.example.shoppingmall.product;

import com.example.shoppingmall.utils.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@AllArgsConstructor
    public class ProductController {
    private ProductService productService;



    @PostMapping("/products")
    public ResponseEntity registerProduct(@RequestBody Product product) {
        if (Validator.isAlpha(product.getName()) && Validator.isNumber(product.getPrice())) {
            log.info(product.getName());
            Product savedProduct = productService.registerProduct(product);

            try {
               log.info(savedProduct.getName());
            } catch (NullPointerException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findProducts(@RequestParam int limit, @RequestParam int currentPage, @RequestParam(required = false) Integer categoryId) {
        log.info("limit = {}", limit);
        log.info("currentPage = {}", currentPage);
        log.info("categoryId = {}", categoryId);

        // TODO null 체크는 어디서 해야할까?
        if(categoryId == null){
            List<Product> products = productService.findProducts(limit, currentPage);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            List<Product> products = productService.findProducts(limit, currentPage, categoryId);
            return new ResponseEntity<>(products, HttpStatus.OK);
        }

    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable int id) {
        // 1. Product 반환 필드 : id가 없어요
        // 2. id 숫자만 들어온 거 맞는지 유효성 검사 추가
        if (!Validator.isNumber(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Product resultProduct = productService.findProduct(id);

        if (resultProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_EXTENDED);
        }
        return new ResponseEntity<>(resultProduct, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){
        if (!Validator.isNumber(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        productService.deleteProduct(id);

        Product product = productService.findProduct(id);
        if(product == null){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/products/delete")
    public ResponseEntity deleteProducts(@RequestBody Map<String, List<Integer>> deleteRequest){
        List<Integer> productIds = deleteRequest.get("productIds");

        if(productIds.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        productService.deleteProducts(productIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


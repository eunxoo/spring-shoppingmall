package com.example.shoppingmall.product;

import com.example.shoppingmall.utils.ApiUtils;
import com.example.shoppingmall.utils.Validator;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;

@Slf4j
@RestController
@AllArgsConstructor
    public class ProductController {
    private ProductService productService;

    @PostMapping("/products")
    public ApiUtils.ApiResult registerProduct(@Valid @RequestBody ProductDto productDto) {
        if (Validator.isNumber(productDto.getPrice())) {
            Product savedProduct = productService.registerProduct(productDto);

            return success(savedProduct, HttpStatus.CREATED);
        } else {
            return error("가격의 형식은 숫자입니다.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/products")
    public ApiUtils.ApiResult findProducts(@PageableDefault(size = 10) Pageable pageable, @RequestParam(required = false) Integer categoryId) {

        // TODO null 체크는 어디서 해야할까?
        if(categoryId == null){
            List<Product> products = productService.findProducts(pageable);
            return success(products, HttpStatus.OK);
        } else {
            List<Product> products = productService.findProducts(pageable, categoryId);
            return success(products, HttpStatus.OK);
        }

    }

    @GetMapping("/products/{id}")
    public ApiUtils.ApiResult findProduct(@PathVariable int id) {
        // 1. Product 반환 필드 : id가 없어요
        // 2. id 숫자만 들어온 거 맞는지 유효성 검사 추가
        if (!Validator.isNumber(id)) {
            return error("id의 형식은 숫자입니다.", HttpStatus.BAD_REQUEST);
        }

        Product resultProduct = productService.findProduct(id);

        if (resultProduct == null) {
            return error("해당하는 상품이 없습니다.", HttpStatus.NOT_EXTENDED);
        }
        return success(resultProduct, HttpStatus.OK);
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


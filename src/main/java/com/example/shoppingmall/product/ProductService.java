package com.example.shoppingmall.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor // 모든 필드를 매개변수로 갖는 생성자 만듦
public class ProductService {

    private ProductRepository productRepository;

    public Product registerProduct(ProductDto productDto){
        Product product = productDto.convertToEntity();
        return productRepository.save(product);
    }

    public List<Product> findProducts(int limit, int currentPage){
        return productRepository.findProducts(limit, currentPage);
    }

    public List<Product> findProducts(int limit, int currentPage, int categoryId){
        return productRepository.findProducts(limit, currentPage, categoryId);
    }

    public Product findProduct(int id){
        return productRepository.findProduct(id);
    }

    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    public void deleteProducts(List<Integer> productIds) {
        productRepository.deleteProducts(productIds);
    }
}

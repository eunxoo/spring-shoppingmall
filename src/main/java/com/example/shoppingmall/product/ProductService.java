package com.example.shoppingmall.product;

import com.example.shoppingmall.member.Member;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor // 모든 필드를 매개변수로 갖는 생성자 만듦
public class ProductService {

    private ProductRepository productRepository;
    private ProductJpaRepository productJpaRepository;

    public Product registerProduct(ProductDto productDto){
        Product product = productDto.convertToEntity();
        return productJpaRepository.save(product);
    }

    public List<Product> findProducts(Pageable pageable){
        return productJpaRepository.findAll(pageable).getContent();
    }

    public List<Product> findProducts(Pageable pageable, int categoryId){
        return productJpaRepository.findAllByCategoryId(pageable, categoryId).getContent();
    }

    public Product findProduct(int id) {
        return productJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    public void deleteProducts(List<Integer> productIds) {
        productRepository.deleteProducts(productIds);
    }
}

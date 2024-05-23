package com.example.shoppingmall.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAllByCategoryId(Pageable pageable, int categoryId);


}

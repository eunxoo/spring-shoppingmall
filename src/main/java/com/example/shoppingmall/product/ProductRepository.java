package com.example.shoppingmall.product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<Integer, Product> productTable = new HashMap<>();

    int id = 0; // DB auto_increment

    public Product save(Product product){
        product.setId(id);
        productTable.put(product.getId(), product);
        id++;
        return productTable.get(id - 1);
    }

//    public List<Product> findProducts(int limit, int currentPage){
//        return new ArrayList<>(product_table.values());
        // Map -> stream -> list
//        return product_table.values().stream().toList();
//    }

    public List<Product> findProducts(int limit, int currentPage){
        Map<Integer, Product> temp = new HashMap<>();
        int id = 0;
        int startIndex = (currentPage - 1) * limit;
        int endIndex = Math.min(startIndex + limit, productTable.size());
        List<Product> result = new ArrayList<>();

        for (int i = startIndex; i < endIndex; i++) {
            if(temp.get(0)!=null){
                result.add(temp.get(i));
            }else{
                result.add(productTable.get(i));
            }

        }
        return result;
    }

    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
        List<Product> resultProducts = new ArrayList<>();

        for(Product product : productTable.values()){
            if(product.getCategoryId() == categoryId){
                resultProducts.add(product);
            }
        }
        return resultProducts;
    }


//    public List<Product> findProducts(int categoryId){
//        return new ArrayList<>(productTable.values());
//    }

    public Product findProduct(int id){
        return productTable.get(id);
    }

    public void deleteProduct(int id) {
        productTable.remove(id);
    }

    public void deleteProducts(List<Integer> productIds) {
        for (int idx = 0; idx < productIds.size(); idx++){
            productTable.remove(productIds.get(idx));
        }
    }
}

package com.example.demo;

import com.example.demo.entity.Product;
import com.example.demo.repository.support.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductRepositorySupportTests {
    private final ProductRepository productRepository;

    @Autowired
    public ProductRepositorySupportTests(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Test
    public void findByProductNameTest() {
        List<Product> products = this.productRepository.findByProductName("apple2");

        products.forEach((product) -> {
            System.out.println(product.getProductName());
        });
    }


}

package com.example.demo;

import com.example.demo.entity.Product;
import com.querydsl.core.types.Predicate;
import com.example.demo.entity.QProduct;
import com.example.demo.repository.QProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class QProductRepositoryTests {
    private final QProductRepository qProductRepository;

    @Autowired
    public QProductRepositoryTests(QProductRepository qProductRepository) {
        this.qProductRepository = qProductRepository;
    }

    @Test
    public void queryDSLTest1() {
        Predicate predicate = QProduct.product.productName.containsIgnoreCase("apple")
                .and(QProduct.product.productPrice.between(100, 1000));

        Optional<Product> foundProduct = this.qProductRepository.findOne(predicate);

        if(foundProduct.isPresent()) {
            Product product = foundProduct.get();
            System.out.println(product.getProductName());
        }
    }

    @Test
    public void queryDSLTest2() {
        QProduct qProduct = QProduct.product;

        Iterable<Product> products = this.qProductRepository.findAll(
                qProduct.productName.contains("apple")
                        .and(qProduct.productPrice.between(1000,5000))
        );

        products.forEach((product) -> {
            System.out.println(product.getProductName());
        });

    }



}

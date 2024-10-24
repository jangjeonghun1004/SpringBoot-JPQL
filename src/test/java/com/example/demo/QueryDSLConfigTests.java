package com.example.demo;

import com.example.demo.entity.QProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class QueryDSLConfigTests {
    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public QueryDSLConfigTests(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }


    @Test
    public void queryDSLTest() {
        QProduct qProduct = QProduct.product;

        List<String> products = this.jpaQueryFactory
                .select(qProduct.productName)
                .from(qProduct)
                .where(qProduct.productName.contains("apple"))
                .fetch();

        products.forEach(System.out::println);
    }
}

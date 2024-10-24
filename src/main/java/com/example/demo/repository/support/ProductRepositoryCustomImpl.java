package com.example.demo.repository.support;

import com.example.demo.entity.Product;
import com.example.demo.entity.QProduct;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {

    public ProductRepositoryCustomImpl() {
        super(Product.class);
    }

    @Override
    public List<Product> findByProductName(String productName) {
        QProduct qProduct = QProduct.product;

        List<Product> products = from(qProduct)
                .where(qProduct.productName.contains("apple"))
                .select(qProduct)
                .fetch();

        return products;
    }
}

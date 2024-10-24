package com.example.demo.repository.support;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findByProductName(String productName);
}

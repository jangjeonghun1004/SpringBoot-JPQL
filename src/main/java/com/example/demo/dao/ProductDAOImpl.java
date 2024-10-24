package com.example.demo.dao;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {
    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Optional<Product> read(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllByProductName(String productName) {
        return this.productRepository.findAllByProductName(productName);
    }

    @Override
    public List<Product> getAllByProductName(String productName) {
        return this.productRepository.queryAllByProductName(productName);
    }

    @Override
    public boolean existsById(Long id) {
        return this.productRepository.existsById(id);
    }

    @Override
    public long countByProductName(String productName) {
        return this.productRepository.countByProductName(productName);
    }

    @Override
    public int deleteByIdAndReturnCount(Long id) {
        return this.productRepository.deleteByIdAndReturnCount(id);
    }

    @Override
    public Optional<Product> findByProductNameIs(String productName) {
        return Optional.ofNullable(this.productRepository.findByProductNameIs(productName));
    }
    public Optional<Product> findByProductNameEquals(String productName) {
        return Optional.ofNullable(this.productRepository.findByProductNameIs(productName));
    }

    @Override
    public List<Product> findByIdIsNot(Long id) {
        return this.productRepository.findByIdIsNot(id);
    }

    @Override
    public List<Product> findByUpdatedAtIsNull() {
        return this.productRepository.findByUpdatedAtIsNull();
    }

    @Override
    public List<Product> findByUpdatedAtIsNotNull() {
        return this.productRepository.findByUpdatedAtIsNotNull();
    }

    @Override
    public List<Product> findByIsActiveIsTrue() {
        return this.productRepository.findByIsActiveIsTrue();
    }

    public List<Product> findByIsActiveIsFalse() {
        return this.productRepository.findByIsActiveIsFalse();
    }

    public Optional<Product> findByIdAndProductName(Long id, String productName) {
        return this.productRepository.findByIdAndProductName(id, productName);
    }

    public List<Product> findByIdOrProductName(Long id, String productName) {
        return this.productRepository.findByIdOrProductName(id, productName);
    }

    public List<Product> findByProductPriceIsGreaterThan(Integer productPrice) {
        return this.productRepository.findByProductPriceIsGreaterThan(productPrice);
    }
    public List<Product> findByProductPriceIsLessThan(Integer productPrice) {
       return this.productRepository.findByProductPriceIsLessThan(productPrice);
    }
    public List<Product> findByProductPriceIsBetween(Integer productLowPrice, Integer productHighPrice) {
        return this.productRepository.findByProductPriceIsBetween(productLowPrice, productHighPrice);
    }

    public List<Product> findByProductNameIsLike(String productName) {
        return this.productRepository.findByProductNameIsLike(productName);
    }
    public List<Product> findByProductNameIsContaining(String productName) {
        return this.productRepository.findByProductNameIsContaining(productName);
    }
    public List<Product> findByProductNameIsContaining(String productName, Sort sort) {
        return this.productRepository.findByProductNameIsContaining(productName, sort);
    }
    public List<Product> findByProductNameIsStartingWith(String productName) {
        return this.productRepository.findByProductNameIsStartingWith(productName);
    }
    public List<Product> findByProductNameIsEndingWith(String productName) {
        return this.productRepository.findByProductNameIsEndingWith(productName);
    }

    public List<Product> findByProductNameIsContainingOrderByIdDesc(String productName) {
        return this.productRepository.findByProductNameIsContainingOrderByIdDesc(productName);
    }
    public List<Product> findByProductNameIsContainingOrderByIdAscProductPriceDesc(String productName) {
        return this.productRepository.findByProductNameIsContainingOrderByIdAscProductPriceDesc(productName);
    }

    public Page<Product> findAll(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    public List<Object[]> queryAllSpecificColumn(String productName) {
        return this.productRepository.queryAllSpecificColumn(productName);
    }

}

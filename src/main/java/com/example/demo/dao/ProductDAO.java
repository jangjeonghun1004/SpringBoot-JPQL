package com.example.demo.dao;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    Product create(Product product);
    Optional<Product> read(Long id);
    Product update(Product product);
    void delete(Long id);

    List<Product> findAllByProductName(String productName);
    List<Product> getAllByProductName(String productName);
    boolean existsById(Long id);
    long countByProductName(String productName);
    int deleteByIdAndReturnCount(Long id);
    Optional<Product> findByProductNameIs(String productName);
    Optional<Product> findByProductNameEquals(String productName);
    List<Product> findByIdIsNot(Long id);
    List<Product> findByUpdatedAtIsNull();
    List<Product> findByUpdatedAtIsNotNull();
    List<Product> findByIsActiveIsTrue();
    List<Product> findByIsActiveIsFalse();
    Optional<Product> findByIdAndProductName(Long id, String productName);
    List<Product> findByIdOrProductName(Long id, String productName);
    List<Product> findByProductPriceIsGreaterThan(Integer productPrice);
    List<Product> findByProductPriceIsLessThan(Integer productPrice);
    List<Product> findByProductPriceIsBetween(Integer productLowPrice, Integer productHighPrice);
    List<Product> findByProductNameIsLike(String productName);
    List<Product> findByProductNameIsContaining(String productName);
    List<Product> findByProductNameIsContaining(String productName, Sort sort);
    List<Product> findByProductNameIsStartingWith(String productName);
    List<Product> findByProductNameIsEndingWith(String productName);
    List<Product> findByProductNameIsContainingOrderByIdDesc(String productName);
    List<Product> findByProductNameIsContainingOrderByIdAscProductPriceDesc(String productName);
    Page<Product> findAll(Pageable pageable);
    List<Object[]> queryAllSpecificColumn(String productName);

}

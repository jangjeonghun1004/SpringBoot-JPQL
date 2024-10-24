package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByProductName(String productName);
    long countByProductName(String productName);
    Product findByProductNameIs(String ProductName);
    Product findByProductNameEquals(String ProductName);
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

    @Query("SELECT p.id, p.productName FROM Product p WHERE p.productName LIKE concat('%', :productName, '%')")
    List<Object[]> queryAllSpecificColumn(@Param("productName") String productName);

    @Query("SELECT p FROM Product p WHERE p.productName = :productName")
    List<Product> queryAllByProductName(@Param("productName") String productName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Product p WHERE p.id = :id")
    int deleteByIdAndReturnCount(@Param("id") Long id);

}

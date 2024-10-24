package com.example.demo.service;

import com.example.demo.dto.ProductCreateDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductListDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {
    ProductDTO create(ProductCreateDTO productCreateDTO);
    ProductDTO read(Long id);
    ProductDTO update(ProductDTO productDTO);
    boolean delete(Long id);

    List<ProductDTO> findAllByProductName(String productName);
    List<ProductDTO> queryAllByProductName(String productName);
    boolean existsById(Long id);
    long countByProductName(String productName);
    int deleteByIdAndReturnCount(Long id);
    ProductDTO findByProductNameIs(String productName);
    ProductDTO findByProductNameEquals(String productName);
    List<ProductDTO> findByIdIsNot(Long id);
    List<ProductDTO> findByUpdatedAtIsNull();
    List<ProductDTO> findByUpdatedAtIsNotNull();
    List<ProductDTO> findByIsActiveIsTrue();
    List<ProductDTO> findByIsActiveIsFalse();
    ProductDTO findByIdAndProductName(Long id, String productName);
    List<ProductDTO> findByIdOrProductName(Long id, String productName);
    List<ProductDTO> findByProductPriceIsGreaterThan(Integer productPrice);
    List<ProductDTO> findByProductPriceIsLessThan(Integer productPrice);
    List<ProductDTO> findByProductPriceIsBetween(Integer productLowPrice, Integer productHighPrice);
    List<ProductDTO> findByProductNameIsLike(String productName);
    List<ProductDTO> findByProductNameIsContaining(String productName);
    List<ProductDTO> findByProductNameIsContaining(String productName, Sort sort);
    List<ProductDTO> findByProductNameIsStartingWith(String productName);
    List<ProductDTO> findByProductNameIsEndingWith(String productName);
    List<ProductDTO> findByProductNameIsContainingOrderByIdDesc(String productName);
    List<ProductDTO> findByProductNameIsContainingOrderByIdAscProductPriceDesc(String productName);

    ProductListDTO findAll(Pageable pageable);
    List<Object[]> queryAllSpecificColumn(String productName);
}

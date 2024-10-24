package com.example.demo.service;

import com.example.demo.dao.ProductDAO;
import com.example.demo.dto.ProductCreateDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductListDTO;
import com.example.demo.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    @Override
    public ProductDTO create(ProductCreateDTO productCreateDTO) {
        Product product = this.productDAO.create(Product.builder()
                .productName(productCreateDTO.getProductName())
                .productPrice(productCreateDTO.getProductPrice())
                .productStock(productCreateDTO.getProductStock())
                .isActive(productCreateDTO.isActive()).build());

        return ProductDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productStock(product.getProductStock())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .isActive(product.isActive()).build();
    }

    @Override
    public ProductDTO read(Long id) {
        Optional<Product> optionalProduct = this.productDAO.read(id);

        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .productStock(product.getProductStock())
                    .productPrice(product.getProductPrice())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt()).build();
        } else {
            return ProductDTO.builder().build();
        }
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        this.productDAO.delete(id);
        return true;
    }

    @Override
    public List<ProductDTO> findAllByProductName(String productName) {
        List<Product> selectedProductList = this.productDAO.findAllByProductName(productName);

        List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();
        selectedProductList.forEach((product) -> {
            productDTOS.add(ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .productStock(product.getProductStock())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt()).build());
        });

        return productDTOS;
    }

    @Override
    public List<ProductDTO> queryAllByProductName(String productName) {
        List<Product> products = this.productDAO.getAllByProductName(productName);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .productStock(product.getProductStock())
                    .productPrice(product.getProductPrice())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt()).build());
        });

        return productDTOs;
    }

    @Override
    public boolean existsById(Long id) {
        return this.productDAO.existsById(id);
    }

    @Override
    public long countByProductName(String productName) {
        return this.productDAO.countByProductName(productName);
    }

    @Override
    public int deleteByIdAndReturnCount(Long id) {
        return this.productDAO.deleteByIdAndReturnCount(id);
    }

    @Override
    public ProductDTO findByProductNameIs(String productName) {
        Optional<Product> selectedProduct = this.productDAO.findByProductNameIs(productName);
        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            return ProductDTO.builder()
                    .id(product.getId())
                    .productStock(product.getProductStock())
                    .productPrice(product.getProductPrice())
                    .productName(product.getProductName())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt()).build();
        } else {
            return ProductDTO.builder().build();
        }
    }

    public ProductDTO findByProductNameEquals(String productName) {
        Optional<Product> selectedProduct = this.productDAO.findByProductNameEquals(productName);
        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            return ProductDTO.builder()
                    .id(product.getId())
                    .productStock(product.getProductStock())
                    .productPrice(product.getProductPrice())
                    .productName(product.getProductName())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt()).build();
        } else {
            return ProductDTO.builder().build();
        }
    }

    @Override
    public List<ProductDTO> findByIdIsNot(Long id) {
        List<Product> products = this.productDAO.findByIdIsNot(id);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .productStock(product.getProductStock())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt()).build());
        });

        return productDTOs;
    }

    @Override
    public List<ProductDTO> findByUpdatedAtIsNull() {
        List<Product> products = this.productDAO.findByUpdatedAtIsNull();

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productStock(product.getProductStock())
                    .productPrice(product.getProductPrice())
                    .productName(product.getProductName())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt()).build());
        });

        return productDTOs;
    }

    @Override
    public List<ProductDTO> findByUpdatedAtIsNotNull() {
        List<Product> products = this.productDAO.findByUpdatedAtIsNotNull();

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productStock(product.getProductStock())
                    .productPrice(product.getProductPrice())
                    .productName(product.getProductName())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt()).build());
        });

        return productDTOs;
    }

    @Override
    public List<ProductDTO> findByIsActiveIsTrue() {
        List<Product> products = this.productDAO.findByIsActiveIsTrue();

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productStock(product.getProductStock())
                    .productPrice(product.getProductPrice())
                    .productName(product.getProductName())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt())
                    .isActive(product.isActive()).build());
        });

        return productDTOs;
    }

    public List<ProductDTO> findByIsActiveIsFalse() {
        List<Product> products = this.productDAO.findByIsActiveIsFalse();

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productStock(product.getProductStock())
                    .productPrice(product.getProductPrice())
                    .productName(product.getProductName())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt())
                    .isActive(product.isActive()).build());
        });

        return productDTOs;
    }

    public ProductDTO findByIdAndProductName(Long id, String productName) {
        Optional<Product> selectedProduct = this.productDAO.findByIdAndProductName(id, productName);

        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            return ProductDTO.builder()
                    .id(product.getId())
                    .productStock(product.getProductStock())
                    .productPrice(product.getProductPrice())
                    .productName(product.getProductName()).build();
        } else {
            return ProductDTO.builder().build();
        }
    }

    public List<ProductDTO> findByIdOrProductName(Long id, String productName) {
        List<Product> products = this.productDAO.findByIdOrProductName(id, productName);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productStock(product.getProductStock())
                    .productPrice(product.getProductPrice())
                    .productName(product.getProductName()).build()
            );
        });

        return  productDTOs;
    }


    public List<ProductDTO> findByProductPriceIsGreaterThan(Integer productPrice) {
        List<Product> products = this.productDAO.findByProductPriceIsGreaterThan(productPrice);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .productStock(product.getProductStock()).build()
            );
        });

        return productDTOs;
    }

    public List<ProductDTO> findByProductPriceIsLessThan(Integer productPrice) {
        List<Product> products = this.productDAO.findByProductPriceIsLessThan(productPrice);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .productStock(product.getProductStock()).build()
            );
        });

        return productDTOs;
    }

    public List<ProductDTO> findByProductPriceIsBetween(Integer productLowPrice, Integer productHighPrice) {
        List<Product> products = this.productDAO.findByProductPriceIsBetween(productLowPrice, productHighPrice);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .productStock(product.getProductStock()).build()
            );
        });

        return productDTOs;
    }

    public List<ProductDTO> findByProductNameIsLike(String productName) {
        List<Product> products = this.productDAO.findByProductNameIsLike(productName);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .productStock(product.getProductStock()).build()
            );
        });

        return productDTOs;
    }
    public List<ProductDTO> findByProductNameIsContaining(String productName) {
        List<Product> products = this.productDAO.findByProductNameIsContaining(productName);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .productStock(product.getProductStock()).build()
            );
        });

        return productDTOs;
    }
    public List<ProductDTO> findByProductNameIsContaining(String productName, Sort sort) {
        List<Product> products = this.productDAO.findByProductNameIsContaining(productName, sort);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .productStock(product.getProductStock()).build()
            );
        });

        return productDTOs;
    }
    public List<ProductDTO> findByProductNameIsStartingWith(String productName) {
        List<Product> products = this.productDAO.findByProductNameIsStartingWith(productName);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .productStock(product.getProductStock()).build()
            );
        });

        return productDTOs;
    }
    public List<ProductDTO> findByProductNameIsEndingWith(String productName) {
        List<Product> products = this.productDAO.findByProductNameIsEndingWith(productName);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .productStock(product.getProductStock()).build()
            );
        });

        return productDTOs;
    }


    public List<ProductDTO> findByProductNameIsContainingOrderByIdDesc(String productName) {
        List<Product> products = this.productDAO.findByProductNameIsContainingOrderByIdDesc(productName);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .productStock(product.getProductStock()).build()
            );
        });

        return productDTOs;
    }
    public List<ProductDTO> findByProductNameIsContainingOrderByIdAscProductPriceDesc(String productName) {
        List<Product> products = this.productDAO.findByProductNameIsContainingOrderByIdAscProductPriceDesc(productName);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .productStock(product.getProductStock()).build()
            );
        });

        return productDTOs;
    }

    public ProductListDTO findAll(Pageable pageable) {
        Page<Product> products = this.productDAO.findAll(pageable);

        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        products.forEach((product) -> {
            productDTOs.add(ProductDTO.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .productStock(product.getProductStock()).build()
            );
        });

        log.info("totalPages = {}", products.getTotalPages());
        log.info("totalElements = {}", products.getTotalElements());
        log.info("currentPageContain = {}", products.getContent());

        return ProductListDTO.builder()
                .productDTOs(productDTOs)
                .totalPages(products.getTotalPages())
                .totalElements(products.getTotalElements()).build();
    }

    public List<Object[]> queryAllSpecificColumn(String productName) {
        return this.productDAO.queryAllSpecificColumn(productName);
    }


}

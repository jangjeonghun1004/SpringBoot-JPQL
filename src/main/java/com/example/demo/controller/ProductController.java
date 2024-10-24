package com.example.demo.controller;

import com.example.demo.dto.ProductCreateDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ProductListDTO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/create")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductCreateDTO productCreateDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.create(productCreateDTO));
    }
    @GetMapping("/read")
    public ResponseEntity<ProductDTO> read(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.read(id));
    }

    @GetMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.delete(id));
    }

    @GetMapping("/findAllByProductName")
    public ResponseEntity<List<ProductDTO>> findAllByProductName(@RequestParam String productName) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findAllByProductName(productName));
    }

    @GetMapping("/queryAllByProductName")
    public ResponseEntity<List<ProductDTO>> queryAllByProductName(@RequestParam String productName) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.queryAllByProductName(productName));
    }

    @GetMapping("/existsById")
    public ResponseEntity<Boolean> existsById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.existsById(id));
    }

    @GetMapping("/countByProductName")
    public ResponseEntity<Long> countByProductName(@RequestParam String productName) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.countByProductName(productName));
    }

    @GetMapping("/deleteByIdAndReturnCount")
    public ResponseEntity<Integer> deleteByIdAndReturnCount(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.deleteByIdAndReturnCount(id));
    }

    @GetMapping("/findByProductNameIs")
    public ResponseEntity<ProductDTO> findByProductNameIs(@RequestParam String productName) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByProductNameIs(productName));
    }

    @GetMapping("/findByProductNameEquals")
    public ResponseEntity<ProductDTO> findByProductNameEquals(@RequestParam String productName) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByProductNameEquals(productName));
    }

    @GetMapping("/findByIdIsNot")
    public ResponseEntity<List<ProductDTO>> findByIdIsNot(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByIdIsNot(id));
    }

    @GetMapping("/findByUpdatedAtIsNull")
    public ResponseEntity<List<ProductDTO>> findByUpdatedAtIsNull() {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByUpdatedAtIsNull());
    }

    @GetMapping("/findByUpdatedAtIsNotNull")
    public ResponseEntity<List<ProductDTO>> findByUpdatedAtIsNotNull() {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByUpdatedAtIsNotNull());
    }

    @GetMapping("/findByIsActiveIsTrue")
    public ResponseEntity<List<ProductDTO>> findByIsActiveIsTrue() {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByIsActiveIsTrue());
    }

    @GetMapping("/findByIsActiveIsFalse")
    public ResponseEntity<List<ProductDTO>> findByIsActiveIsFalse() {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByIsActiveIsFalse());
    }

    @GetMapping("/findByIdAndProductName")
    public ResponseEntity<ProductDTO> findByIdAndProductName(
            @RequestParam Long id,
            @RequestParam String productName
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByIdAndProductName(id, productName));
    }

    @GetMapping("/findByIdOrProductName")
    public ResponseEntity<List<ProductDTO>> findByIdOrProductName(
            @RequestParam Long id,
            @RequestParam String productName
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByIdOrProductName(id, productName));
    }

    @GetMapping("/findByProductPriceIsGreaterThan")
    public ResponseEntity<List<ProductDTO>> findByProductPriceIsGreaterThan(@RequestParam Integer productPrice) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByProductPriceIsGreaterThan(productPrice));
    }

    @GetMapping("/findByProductPriceIsLessThan")
    public ResponseEntity<List<ProductDTO>> findByProductPriceIsLessThan(@RequestParam Integer productPrice) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByProductPriceIsLessThan(productPrice));
    }

    @GetMapping("/findByProductPriceIsBetween")
    public ResponseEntity<List<ProductDTO>> findByProductPriceIsBetween(
            @RequestParam Integer productLowPrice,
            @RequestParam Integer productHighPrice
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByProductPriceIsBetween(productLowPrice, productHighPrice));
    }

    @GetMapping("/findByProductNameIsLike")
    public ResponseEntity<List<ProductDTO>> findByProductNameIsLike(@RequestParam String productName) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByProductNameIsLike(productName));
    }

    @GetMapping("/findByProductNameIsContaining")
    public ResponseEntity<List<ProductDTO>> findByProductNameIsContaining(@RequestParam String productName) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByProductNameIsContaining(productName));
    }

    @GetMapping("/findByProductNameIsContainingSort")
    public ResponseEntity<List<ProductDTO>> findByProductNameIsContainingSort(@RequestParam String productName) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByProductNameIsContaining(
                productName,
                Sort.by(Sort.Order.desc("productPrice"))
        ));
    }

    @GetMapping("/findByProductNameIsStartingWith")
    public ResponseEntity<List<ProductDTO>> findByProductNameIsStartingWith(@RequestParam String productName) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByProductNameIsStartingWith(productName));
    }

    @GetMapping("/findByProductNameIsEndingWith")
    public ResponseEntity<List<ProductDTO>> findByProductNameIsEndingWith(@RequestParam String productName) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByProductNameIsEndingWith(productName));
    }

    @GetMapping("/findByProductNameIsContainingOrderByIdDesc")
    public ResponseEntity<List<ProductDTO>> findByProductNameIsContainingOrderByIdDesc(@RequestParam String productName) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByProductNameIsContainingOrderByIdDesc(productName));
    }

    @GetMapping("/findByProductNameIsContainingOrderByIdAscProductPriceDesc")
    public ResponseEntity<List<ProductDTO>> findByProductNameIsContainingOrderByIdAscProductPriceDesc(@RequestParam String productName) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findByProductNameIsContainingOrderByIdAscProductPriceDesc(productName));
    }

    @GetMapping("/findAll")
    public ResponseEntity<ProductListDTO> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.findAll(
                PageRequest.of(0, 2, Sort.by(Sort.Order.desc("productPrice"))))
        );
    }

    @GetMapping("/queryAllSpecificColumn")
    public ResponseEntity<List<Object[]>> queryAllSpecificColumn(@RequestParam String productName) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.queryAllSpecificColumn(productName));
    }



}

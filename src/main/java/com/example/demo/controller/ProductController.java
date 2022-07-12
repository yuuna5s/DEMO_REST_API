package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.Response;
import com.example.demo.service.implementation.ProductServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImp productService;

    @GetMapping("/list")
    public ResponseEntity<Response> getProducts() {
        return ResponseEntity.ok(
            Response.builder()
                    .timestamp(LocalDateTime.now())
                    .statuscode(HttpStatus.OK.value())
                    .status(HttpStatus.OK)
                    .reason("OK")
                    .message("Products retrieved successfully")
                    .data(Map.of("products", productService.list(10)))
                    .build());
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity<Response> getProductByProductId(@PathVariable("productId") String productId) {
        return ResponseEntity.ok(
            Response.builder()
                    .timestamp(LocalDateTime.now())
                    .statuscode(HttpStatus.OK.value())
                    .status(HttpStatus.OK)
                    .reason("OK")
                    .message("Product retrieved successfully")
                    .data(Map.of("product", productService.getProductByProductId(productId)))
                    .build());
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveProduct(@RequestBody @Valid Product product) {
        return ResponseEntity.ok(
            Response.builder()
                    .timestamp(LocalDateTime.now())
                    .statuscode(HttpStatus.CREATED.value())
                    .status(HttpStatus.CREATED)
                    .reason("Created")
                    .message("Product created successfully")
                    .data(Map.of("product", productService.create(product)))
                    .build());
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Response> deleteProduct(@PathVariable("productId") String productId) {
        return ResponseEntity.ok(
            Response.builder()
                    .timestamp(LocalDateTime.now())
                    .statuscode(HttpStatus.OK.value())
                    .status(HttpStatus.OK)
                    .reason("OK")
                    .message("Product deleted successfully")
                    .data(Map.of("product", productService.deleteByProductId(productId)))
                    .build());
    }
}

package com.farmfox.farmfoxapp.controller;

import com.farmfox.farmfoxapp.configuration.ApiResponse;
import com.farmfox.farmfoxapp.entity.Product;
import com.farmfox.farmfoxapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
@Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProduct(
            @PathVariable Long id) {

        Product product=productService.getProductById(id);
        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(
                            "FAILED",
                            "Product not found",
                            null
                    ));
        }
        ApiResponse<Product> response =
                new ApiResponse<>(
                        "SUCCESS",
                        "Product fetched successfully",
                        product
                );

        return ResponseEntity.ok(response);
    }
}
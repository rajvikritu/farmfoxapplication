package com.farmfox.farmfoxapp.controller;

import com.farmfox.farmfoxapp.configuration.ApiResponse;
import com.farmfox.farmfoxapp.entity.Product;
import com.farmfox.farmfoxapp.entity.RecommendedProducts;
import com.farmfox.farmfoxapp.entity.ValueCombo;
import com.farmfox.farmfoxapp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ApiResponse<Product>> getProductsById(
            @PathVariable Long id) {

        Product product=productService.getProductById(id).orElse(new Product());
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

    @GetMapping("/products")
    public ResponseEntity<ApiResponse<List<Product>>> getProduct() {

        List<Product> product=productService.getAllProduct();
        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(
                            "FAILED",
                            "Product not found",
                            null
                    ));
        }
        ApiResponse<List<Product>> response =
                new ApiResponse<List<Product>>(
                        "SUCCESS",
                        "Product fetched successfully",
                        product
                );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/value-combos")
    public ResponseEntity<ApiResponse<List<ValueCombo>>> getValueCombo() {

        List<ValueCombo> valueComboList =productService.getValueCombo();
        if(valueComboList == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(
                            "FAILED",
                            "Product not found",
                            null
                    ));
        }
        ApiResponse<List<ValueCombo>> response =
                new ApiResponse<List<ValueCombo>>(
                        "SUCCESS",
                        "Product fetched successfully",
                        valueComboList
                );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/recommended-products")
    public ResponseEntity<ApiResponse<List<RecommendedProducts>>> getRecommendedProducts() {

        List<RecommendedProducts> recommendedProducts =
                productService.getRecommendedProducts();

        ApiResponse<List<RecommendedProducts>> response =
                new ApiResponse<>(
                        "SUCCESS",
                        "Recommended products fetched successfully",
                        recommendedProducts
                );

        return ResponseEntity.ok(response);
    }

}
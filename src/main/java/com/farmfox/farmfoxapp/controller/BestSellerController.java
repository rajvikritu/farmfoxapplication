package com.farmfox.farmfoxapp.controller;

import com.farmfox.farmfoxapp.configuration.ApiResponse;
import com.farmfox.farmfoxapp.entity.BestSellerProduct;
import com.farmfox.farmfoxapp.service.BestSellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class BestSellerController {

    private final BestSellerService bestSellerService;

    public BestSellerController(BestSellerService bestSellerService) {
        this.bestSellerService = bestSellerService;
    }

    @GetMapping("/bestseller")
    public ResponseEntity<ApiResponse<List<BestSellerProduct>>> getBestSellerProducts() {

        List<BestSellerProduct> product=bestSellerService.getBestSellerProduct();
        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(
                            "FAILED",
                            "Best Seller Product not found",
                            null
                    ));
        }
        ApiResponse<List<BestSellerProduct>> response =
                new ApiResponse<List<BestSellerProduct>>(
                        "SUCCESS",
                        "Product fetched successfully",
                        product
                );

        return ResponseEntity.ok(response);
    }
}

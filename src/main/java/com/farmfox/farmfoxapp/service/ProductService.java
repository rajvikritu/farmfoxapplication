package com.farmfox.farmfoxapp.service;

import com.farmfox.farmfoxapp.entity.Product;
import com.farmfox.farmfoxapp.entity.RecommendedProducts;
import com.farmfox.farmfoxapp.entity.ValueCombo;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductById(Long id);
    List<Product> getAllProduct();
    List<ValueCombo> getValueCombo();
    List<RecommendedProducts> getRecommendedProducts();
}

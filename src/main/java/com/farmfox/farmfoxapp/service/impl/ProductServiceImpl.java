package com.farmfox.farmfoxapp.service.impl;

import com.farmfox.farmfoxapp.entity.Product;
import com.farmfox.farmfoxapp.entity.RecommendedProducts;
import com.farmfox.farmfoxapp.entity.ValueCombo;
import com.farmfox.farmfoxapp.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class ProductServiceImpl implements ProductService {

        @Override
        public Optional<Product> getProductById(Long id) {

            return Optional.of(new Product(
                    1L,
                    "FarmFox Premium Almonds",
                    "500g",
                    599.00,
                    699.00,
                    100.00,
                    false,
                    "https://cdn.farmfox.com/products/almond.jpg"
            ));
        }

    @Override
    public List<Product> getAllProduct() {
        return List.of(new Product(
                1L,
                "FarmFox Premium Almonds",
                "500g",
                599.00,
                699.00,
                100.00,
                false,
                "https://cdn.farmfox.com/products/almond.jpg"
        ));
    }

    @Override
    public List<ValueCombo> getValueCombo() {
        return List.of(new ValueCombo(
                1L,
                "Premium Nuts & Dry Fruits Combo",
                "https://cdn.farmfox.com/combo1.png",
                761.0,
                895.0,
                "1.3",
                5.0,
                5,
                true,
                true
        ));
    }

    public List<RecommendedProducts> getRecommendedProducts() {
        return List.of(
                new RecommendedProducts(
                        1,
                        "FarmFox Premium Dried Blueberry & Cranberry Mix",
                        "https://cdn.farmfox.com/products/cranberry.jpg",
                        302,
                        355,
                        4.8,
                        4,
                        true,
                        false
                )
        );
    }
}

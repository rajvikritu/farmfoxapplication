package com.farmfox.farmfoxapp.service;

import com.farmfox.farmfoxapp.entity.Product;
import org.springframework.stereotype.Service;

@Service
    public class ProductServiceImpl implements ProductService {

        @Override
        public Product getProductById(Long id) {

            return new Product(
                    1L,
                    "FarmFox Premium Almonds",
                    "500g",
                    599,
                    699,
                    100,
                    false,
                    "https://cdn.farmfox.com/products/almond.jpg"
            );
        }
}

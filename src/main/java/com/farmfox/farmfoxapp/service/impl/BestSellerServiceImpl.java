package com.farmfox.farmfoxapp.service.impl;

import com.farmfox.farmfoxapp.entity.BestSellerProduct;
import com.farmfox.farmfoxapp.service.BestSellerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BestSellerServiceImpl implements BestSellerService {
    @Override
    public List<BestSellerProduct> getBestSellerProduct() {
        return List.of(
                new BestSellerProduct(
                        1L,
                        "FarmFox Celebration Date Bites Tin 200g",
                        "https://cdn.farmfox.com/date-bites.jpg",
                        319.0,
                        375.0,
                        56.0,
                        false,
                        false,
                        4.8,
                        2732
                )
        );
    }
}

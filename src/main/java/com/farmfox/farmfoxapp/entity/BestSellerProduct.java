package com.farmfox.farmfoxapp.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BestSellerProduct {
    private Long id;
    private String productName;
    private String imageUrl;

    private Double price;
    private Double originalPrice;
    private Double saveAmount;

    private boolean soldOut;
    private boolean bestSeller;

    private Double rating;
    private Integer reviewCount;
}

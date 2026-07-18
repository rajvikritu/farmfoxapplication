package com.farmfox.farmfoxapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendedProducts {
    private Integer id;
    private String productName;
    private String imageUrl;
    private Integer price;
    private Integer originalPrice;
    private Double rating;
    private Integer reviewCount;
    private Boolean soldOut;
    private Boolean trending;
}

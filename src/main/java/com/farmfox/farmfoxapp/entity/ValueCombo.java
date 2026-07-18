package com.farmfox.farmfoxapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ValueCombo {
    private Long id;
    private String productName;
    private String imageUrl;

    private Double price;
    private Double originalPrice;
    private String pricePerGram;

    private Double rating;
    private Integer reviewCount;

    private boolean valuePack;
    private boolean soldOut;
}

package com.farmfox.farmfoxapp.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String batchId;
    private String name;
    private String weight;
    private Double price;
    private Double originalPrice;
    private Double saveAmount;
    private Boolean soldOut;
    private String imageUrl;
}


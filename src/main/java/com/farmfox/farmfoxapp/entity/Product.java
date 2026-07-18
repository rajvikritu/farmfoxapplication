package com.farmfox.farmfoxapp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private String weight;
    private Double price;
    private Double originalPrice;
    private Double saveAmount;
    private Boolean soldOut;
    private String imageUrl;

    public Product()
    {
        log.info("inside product constructor");
    }
    public Product(Long id,
                   String name,
                   String weight,
                   Double price,
                   Double originalPrice,
                   Double saveAmount,
                   Boolean soldOut,
                   String imageUrl) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.originalPrice = originalPrice;
        this.saveAmount = saveAmount;
        this.soldOut = soldOut;
        this.imageUrl = imageUrl;
    }
}


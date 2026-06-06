package com.farmfox.farmfoxapp.entity;

public class Product {
    private Long id;
    private String name;
    private String weight;
    private Integer price;
    private Integer originalPrice;
    private Integer saveAmount;
    private Boolean soldOut;
    private String imageUrl;

    public Product(Long id,
                   String name,
                   String weight,
                   Integer price,
                   Integer originalPrice,
                   Integer saveAmount,
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public Integer getSaveAmount() {
        return saveAmount;
    }

    public Boolean getSoldOut() {
        return soldOut;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}


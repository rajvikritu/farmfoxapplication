package com.farmfox.farmfoxapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class BrandPromiseBanner {
    private String imageUrl;
    private String redirectUrl;
}

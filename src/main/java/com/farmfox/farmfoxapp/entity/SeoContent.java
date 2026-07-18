package com.farmfox.farmfoxapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeoContent {
    private String heading;
    private String subHeading;
    private String description;
}

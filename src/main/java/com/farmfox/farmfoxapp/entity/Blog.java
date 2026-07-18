package com.farmfox.farmfoxapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private Long id;
    private String title;
    private String category;
    private String description;
    private String imageUrl;
    private String publishedDate;
    private String slug;
}

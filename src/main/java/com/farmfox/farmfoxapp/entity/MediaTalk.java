package com.farmfox.farmfoxapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaTalk {
    private Integer id;
    private String title;
    private String imageUrl;
    private String articleUrl;
}

package com.farmfox.farmfoxapp.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "farmfox.data")
@Data
public class FarmFoxDataConfig {
    private String bestsellerpath;
    private String valueComboProductpath;
    private String recommendedProductPath;
    private String videoBannerPath;
    private String collectionDetailsPath;
    private String promoVideoDetaisPath;
    private String brandPromiseDetaisPath;
    private String blogsDetailsPath;
    private String faqsDetailsPath;
    private String seoContentDetailsPath;
    private String mediaTalksDetailsPath;
    private String productDetailsPath;
}

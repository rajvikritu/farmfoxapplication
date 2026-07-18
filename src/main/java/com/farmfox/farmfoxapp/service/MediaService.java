package com.farmfox.farmfoxapp.service;

import com.farmfox.farmfoxapp.entity.*;

import java.util.List;

public interface MediaService {
    VideoBanner getVideoBannerDetails();
    CollectionBannerDetail getCollectionDetail();
    PromoVideo getPromoVideo();
    BrandPromiseBanner getBrandPromiseBanner();
    List<Blog> getBlogs();
    List<Faq> getFaqs();
    SeoContent getSeoContent();
    List<MediaTalk> getMediaTalks();
}

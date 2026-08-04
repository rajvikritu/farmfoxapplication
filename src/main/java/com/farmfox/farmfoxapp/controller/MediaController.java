package com.farmfox.farmfoxapp.controller;

import com.farmfox.farmfoxapp.configuration.ApiResponse;
import com.farmfox.farmfoxapp.entity.*;
import com.farmfox.farmfoxapp.service.MediaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MediaController {

    private final MediaService mediaService;

    public MediaController(MediaService videoBannerService) {
        this.mediaService = videoBannerService;
    }

    @GetMapping("/video-banner")
    public ResponseEntity<ApiResponse<VideoBanner>> getVideoBannerDetails() {
        VideoBanner bannerDetail =  mediaService.getVideoBannerDetails();
        ApiResponse<VideoBanner> response =
                new ApiResponse<VideoBanner>(
                        "SUCCESS",
                        "video banner fetched successfully",
                        bannerDetail
                );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/collection-banner")
    public ResponseEntity<ApiResponse<CollectionBannerDetail>> getCollectionBannerDetails() {
        CollectionBannerDetail collectionBannerDetail =  mediaService.getCollectionDetail();
        ApiResponse<CollectionBannerDetail> response =
                new ApiResponse<CollectionBannerDetail>(
                        "SUCCESS",
                        "collection banner fetched successfully",
                        collectionBannerDetail
                );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/promo-video-banner")
    public ResponseEntity<ApiResponse<PromoVideo>> getPromoVideoDetails() {
        PromoVideo promoVideo =  mediaService.getPromoVideo();
        ApiResponse<PromoVideo> response =
                new ApiResponse<PromoVideo>(
                        "SUCCESS",
                        "collection banner fetched successfully",
                        promoVideo
                );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/brand-promise-banner")
    public ResponseEntity<ApiResponse<BrandPromiseBanner>> getBrandPromiseBannerDetails() {
        BrandPromiseBanner brandPromiseBanner =  mediaService.getBrandPromiseBanner();
        ApiResponse<BrandPromiseBanner> response =
                new ApiResponse<BrandPromiseBanner>(
                        "SUCCESS",
                        "collection banner fetched successfully",
                        brandPromiseBanner
                );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/blogs")
    public ResponseEntity<ApiResponse<List<Blog>>> getBlogs() {
        List<Blog> blogs = mediaService.getBlogs();

        ApiResponse<List<Blog>> response =
                new ApiResponse<>(
                        "SUCCESS",
                        "Blogs fetched successfully",
                        blogs
                );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/faqs")
    public ResponseEntity<ApiResponse<List<Faq>>> getFaqs() {
        List<Faq> faqs = mediaService.getFaqs();

        ApiResponse<List<Faq>> response =
                new ApiResponse<>(
                        "SUCCESS",
                        "FAQs fetched successfully",
                        faqs
                );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/seo-content")
    public ResponseEntity<ApiResponse<SeoContent>> getSeoContent() {

        SeoContent seoContent = mediaService.getSeoContent();

        ApiResponse<SeoContent> response =
                new ApiResponse<>(
                        "SUCCESS",
                        "SEO content fetched successfully",
                        seoContent
                );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/media-talks")
    public ResponseEntity<ApiResponse<List<MediaTalk>>> getMediaTalks() {
        List<MediaTalk> mediaTalks = mediaService.getMediaTalks();
        ApiResponse<List<MediaTalk>> response =
                new ApiResponse<>(
                        "SUCCESS",
                        "media talks fetched successfully",
                        mediaTalks
                );

        return ResponseEntity.ok(response);
    }
}

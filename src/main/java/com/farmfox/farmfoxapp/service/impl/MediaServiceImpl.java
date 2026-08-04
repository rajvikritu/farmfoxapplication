package com.farmfox.farmfoxapp.service.impl;

import com.farmfox.farmfoxapp.configuration.FarmFoxDataConfig;
import com.farmfox.farmfoxapp.configuration.SupplierConfig;
import com.farmfox.farmfoxapp.design.JSONFileReader;
import com.farmfox.farmfoxapp.entity.*;
import com.farmfox.farmfoxapp.service.MediaService;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MediaServiceImpl implements MediaService {

    private final FarmFoxDataConfig farmFoxDataConfig;
    private final SupplierConfig supplierConfig;
    private final JSONFileReader jsonFileReader;

    public MediaServiceImpl(FarmFoxDataConfig farmFoxDataConfig, SupplierConfig supplierConfig, JSONFileReader jsonFileReader) {
        this.farmFoxDataConfig = farmFoxDataConfig;
        this.supplierConfig = supplierConfig;
        this.jsonFileReader = jsonFileReader;
    }
    VideoBanner videoBanner = new VideoBanner();
    CollectionBannerDetail collectionBannerDetail = new CollectionBannerDetail();
    PromoVideo promoVideo = new PromoVideo();
    BrandPromiseBanner brandPromiseBanner = new BrandPromiseBanner();
    List<Blog> blogs = new ArrayList<>();
    List<Faq> faqs = new ArrayList<>();
    SeoContent seoContent = new SeoContent();
    List<MediaTalk> mediaTalks = new ArrayList<>();

    @PostConstruct
    void init()
    {
        populateVideoBannerDetails();
        populateCollectionBannerDetails();
        populatePromoVideoDetails();
        populateBrandPromiseBannerDetails();
        populateBlogsDetails();
        populateFaqsDetails();
        populateMediaTalks();
        populateSEOContentDetails();
    }

    private void populateVideoBannerDetails() {
        videoBanner = jsonFileReader.readJson(
                supplierConfig.getBucketName(),
                supplierConfig.getProtocol() ,
                farmFoxDataConfig.getVideoBannerPath(),
                new TypeReference<VideoBanner>() {}
        );
    }
    private void populateCollectionBannerDetails() {
        collectionBannerDetail = jsonFileReader.readJson(
                supplierConfig.getBucketName(),
                supplierConfig.getProtocol() ,
                farmFoxDataConfig.getCollectionDetailsPath(),
                new TypeReference<CollectionBannerDetail>() {}
        );
    }
    private void populatePromoVideoDetails() {
        promoVideo = jsonFileReader.readJson(
                supplierConfig.getBucketName(),
                supplierConfig.getProtocol() ,
                farmFoxDataConfig.getPromoVideoDetaisPath(),
                new TypeReference<PromoVideo>() {}
        );
    }

    private void populateBrandPromiseBannerDetails() {
        brandPromiseBanner = jsonFileReader.readJson(
                supplierConfig.getBucketName(),
                supplierConfig.getProtocol() ,
                farmFoxDataConfig.getBrandPromiseDetaisPath(),
                new TypeReference<BrandPromiseBanner>() {}
        );
    }

    private void populateBlogsDetails() {
        blogs = jsonFileReader.readJson(
                supplierConfig.getBucketName(),
                supplierConfig.getProtocol() ,
                farmFoxDataConfig.getBlogsDetailsPath(),
                new TypeReference<List<Blog>>() {}
        );
    }

    private void populateFaqsDetails() {
        faqs = jsonFileReader.readJson(
                supplierConfig.getBucketName(),
                supplierConfig.getProtocol() ,
                farmFoxDataConfig.getFaqsDetailsPath(),
                new TypeReference<List<Faq>>() {}
        );
    }

    private void populateSEOContentDetails() {
        seoContent = jsonFileReader.readJson(
                supplierConfig.getBucketName(),
                supplierConfig.getProtocol() ,
                farmFoxDataConfig.getSeoContentDetailsPath(),
                new TypeReference<SeoContent>() {}
        );
    }

    private void populateMediaTalks() {
        mediaTalks = jsonFileReader.readJson(
                supplierConfig.getBucketName(),
                supplierConfig.getProtocol() ,
                farmFoxDataConfig.getMediaTalksDetailsPath(),
                new TypeReference<List<MediaTalk>>() {}
        );
    }

    @Override
    public VideoBanner getVideoBannerDetails() {
        return videoBanner;
    }

    @Override
    public CollectionBannerDetail getCollectionDetail() {
        return collectionBannerDetail;
    }

    @Override
    public PromoVideo getPromoVideo() {
        return promoVideo;
    }

    @Override
    public BrandPromiseBanner getBrandPromiseBanner() {
        return brandPromiseBanner;
    }

    @Override
    public List<Blog> getBlogs() {
        return blogs;
    }

    @Override
    public List<Faq> getFaqs() {
        return faqs;
    }

    @Override
    public SeoContent getSeoContent() {
        return seoContent;
    }

    @Override
    public List<MediaTalk> getMediaTalks() {
       return mediaTalks;
    }

}

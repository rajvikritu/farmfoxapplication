package com.farmfox.farmfoxapp.service.impl;

import com.farmfox.farmfoxapp.entity.*;
import com.farmfox.farmfoxapp.service.MediaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaServiceImpl implements MediaService {

    @Override
    public VideoBanner getVideoBannerDetails() {
        return VideoBanner.builder()
                .videoBannerUrl("https://cdn.farmfox.com/videos/chocolate.mp4")
                .build();
    }

    @Override
    public CollectionBannerDetail getCollectionDetail() {
        return CollectionBannerDetail.builder()
                .collectionDetailTitle("FarmFox Collection Banner")
                .collectionDetailImageUrl("https://cdn.farmfox.com/banners/collection-banner.jpg")
                .build();
    }

    @Override
    public PromoVideo getPromoVideo() {
        return PromoVideo.builder().videoUrl("https://cdn.farmfox.com/videos/smoked-almond-cashew-mix.mp4").build();
    }

    @Override
    public BrandPromiseBanner getBrandPromiseBanner() {
        return BrandPromiseBanner.builder().imageUrl("https://cdn.farmfox.com/banners/brand-promise-banner.jpg").redirectUrl("/about-us").build();
    }

    public List<Blog> getBlogs() {
        return List.of(
                new Blog(
                        1L,
                        "Important Health Benefits Of Brazil Nuts Explained",
                        "Nutritional Benefits",
                        "Brazil nuts are seeds obtained from the Brazil nut tree...",
                        "https://cdn.farmfox.com/blog1.jpg",
                        "May 30, 2025",
                        "important-health-benefits-of-brazil-nuts"
                )
        );
    }

    public List<Faq> getFaqs() {
        return List.of(
                new Faq(
                        1,
                        "Where can I buy Premium Dry Fruits and Nuts online?",
                        "You can purchase premium quality dry fruits and nuts directly from FarmFox website."
                ),
                new Faq(
                        2,
                        "What are the benefits of Dry Fruits?",
                        "Dry fruits are rich in vitamins, minerals, antioxidants and healthy fats."
                )
        );
    }

    public SeoContent getSeoContent() {
        return SeoContent.builder()
                .heading("SHOP DRY FRUITS, NUTS, BERRIES, DATES, AND MIXES ONLINE")
                .subHeading("Did you know that you can shop best quality dry fruits and nuts in a click?")
                .description("FarmFox is where you get the best quality...")
                .build();
    }

    public List<MediaTalk> getMediaTalks() {
        return List.of(
                new MediaTalk(
                        1,
                        "FarmFox Festive Special",
                        "https://cdn.farmfox.com/media/media1.jpg",
                        "https://example.com/article1"
                ),
                new MediaTalk(
                        2,
                        "Health Benefits of Pumpkin",
                        "https://cdn.farmfox.com/media/media2.jpg",
                        "https://example.com/article2"
                )
        );
    }

}

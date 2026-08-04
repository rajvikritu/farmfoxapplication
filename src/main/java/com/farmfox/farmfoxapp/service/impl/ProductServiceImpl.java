package com.farmfox.farmfoxapp.service.impl;

import com.farmfox.farmfoxapp.configuration.FarmFoxDataConfig;
import com.farmfox.farmfoxapp.configuration.SupplierConfig;
import com.farmfox.farmfoxapp.design.JSONFileReader;
import com.farmfox.farmfoxapp.design.impl.LocalFileReader;
import com.farmfox.farmfoxapp.design.impl.S3FileReader;
import com.farmfox.farmfoxapp.entity.BestSellerProduct;
import com.farmfox.farmfoxapp.entity.Product;
import com.farmfox.farmfoxapp.entity.RecommendedProducts;
import com.farmfox.farmfoxapp.entity.ValueCombo;
import com.farmfox.farmfoxapp.service.ProductService;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
    public class ProductServiceImpl implements ProductService {

    private final FarmFoxDataConfig farmFoxDataConfig;
    private final SupplierConfig supplierConfig;
    private final JSONFileReader jsonFileReader;

    List<Product> products = new ArrayList<>();
    List<ValueCombo> valueCombos = new ArrayList<>();
    List<RecommendedProducts> recommendedProducts = new ArrayList<>();

    public ProductServiceImpl(FarmFoxDataConfig farmFoxDataConfig, SupplierConfig supplierConfig,JSONFileReader jsonFileReader) {
        this.farmFoxDataConfig = farmFoxDataConfig;
        this.supplierConfig = supplierConfig;
        this.jsonFileReader = jsonFileReader;
    }

    @PostConstruct
        void init()
        {
            populateProducts();
            populateValueComboProducts();
            populateRecommendedProducts();
        }

    private void populateRecommendedProducts() {
        System.out.println("populating products::" + supplierConfig.getBucketName() + ":::" + supplierConfig.getProtocol() + ":::" + farmFoxDataConfig.getRecommendedProductPath());
        recommendedProducts = jsonFileReader.readJson(
                supplierConfig.getBucketName(),
                supplierConfig.getProtocol() ,
                farmFoxDataConfig.getRecommendedProductPath(),
                new TypeReference<List<RecommendedProducts>>() {}
        );
    }

    private void populateProducts() {
        System.out.println("populating products::" + supplierConfig.getBucketName() + ":::" + supplierConfig.getProtocol() + ":::" + farmFoxDataConfig.getProductDetailsPath());
        products = jsonFileReader.readJson(
                supplierConfig.getBucketName(),
                supplierConfig.getProtocol() ,
                farmFoxDataConfig.getProductDetailsPath(),
                new TypeReference<List<Product>>() {}
        );
    }

    private void populateValueComboProducts() {
        System.out.println("populating products::" + supplierConfig.getBucketName() + ":::" + supplierConfig.getProtocol() + ":::" + farmFoxDataConfig.getValueComboProductpath());
        valueCombos = jsonFileReader.readJson(
                supplierConfig.getBucketName(),
                supplierConfig.getProtocol() ,
                farmFoxDataConfig.getValueComboProductpath(),
                new TypeReference<List<ValueCombo>>() {}
        );
    }

    @Override
        public Optional<Product> getProductById(Long id) {

            return products.stream().filter(p -> p.getId().equals(id)).findFirst();
        }

    @Override
    public List<Product> getAllProduct() {
        return products;
    }

    @Override
    public List<ValueCombo> getValueCombo() {
        return valueCombos;
    }

    @Override
    public List<RecommendedProducts> getRecommendedProducts() {
        return recommendedProducts;
    }
}

package com.farmfox.farmfoxapp.service.impl;

import com.farmfox.farmfoxapp.configuration.FarmFoxDataConfig;
import com.farmfox.farmfoxapp.configuration.SupplierConfig;
import com.farmfox.farmfoxapp.design.JSONFileReader;
import com.farmfox.farmfoxapp.design.impl.LocalFileReader;
import com.farmfox.farmfoxapp.design.impl.S3FileReader;
import com.farmfox.farmfoxapp.entity.BestSellerProduct;
import com.farmfox.farmfoxapp.service.BestSellerService;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BestSellerServiceImpl implements BestSellerService {

    private final FarmFoxDataConfig farmFoxDataConfig;
    private final SupplierConfig supplierConfig;
    private final JSONFileReader jsonFileReader;
    List<BestSellerProduct> bestSellerProducts = new ArrayList<>();

    public BestSellerServiceImpl(FarmFoxDataConfig farmFoxDataConfig, SupplierConfig supplierConfig, JSONFileReader jsonFileReader) {
        this.farmFoxDataConfig = farmFoxDataConfig;
        this.supplierConfig = supplierConfig;
        this.jsonFileReader = jsonFileReader;
    }

    @PostConstruct
    void init()
    {
        bestSellerProducts = jsonFileReader.readJson(
                supplierConfig.getBucketName(),
                supplierConfig.getProtocol() ,
                farmFoxDataConfig.getBestsellerpath(),
                new TypeReference<List<BestSellerProduct>>() {}
        );
    }
    @Override
    public List<BestSellerProduct> getBestSellerProduct() {
        return bestSellerProducts;
    }

}

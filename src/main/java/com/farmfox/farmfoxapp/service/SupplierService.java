package com.farmfox.farmfoxapp.service;

import com.farmfox.farmfoxapp.configuration.SupplierConfig;
import com.farmfox.farmfoxapp.entity.SupplierDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Service
public class SupplierService {
    private final SupplierConfig supplierConfig;
    private final FileReaderFactory factory;
    private final ObjectMapper objectMapper;
    private final Map<Integer, SupplierDTO> supplierDTOMap = new HashMap<>();

    public SupplierService(SupplierConfig supplierConfig, FileReaderFactory factory, ObjectMapper objectMapper) {
        this.supplierConfig = supplierConfig;
        this.factory = factory;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void init() throws Exception {
        String path = supplierConfig.buildPath();
        System.out.println("path :: "+path);
        String json = factory.read(path);
        SupplierDTO supplierDTO = objectMapper.readValue(json, SupplierDTO.class);
        supplierDTOMap.put(1, supplierDTO);
    }

    public SupplierDTO fetchSupplierDetails() {
        return supplierDTOMap.getOrDefault(1, new SupplierDTO());
    }
}

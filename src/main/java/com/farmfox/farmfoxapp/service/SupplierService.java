package com.farmfox.farmfoxapp.service;

import com.farmfox.farmfoxapp.configuration.SupplierConfig;
import com.farmfox.farmfoxapp.entity.ConfigDTO;
import com.farmfox.farmfoxapp.entity.LotDetailsDTO;
import com.farmfox.farmfoxapp.entity.LotResponseDTO;
import com.farmfox.farmfoxapp.entity.SupplierDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

@Service
public class SupplierService {
    private final SupplierConfig supplierConfig;
    private final FileReaderFactory factory;
    private final ObjectMapper objectMapper;
    private final Map<Integer, ConfigDTO> configDTOMap = new HashMap<>();

    public SupplierService(SupplierConfig supplierConfig, FileReaderFactory factory, ObjectMapper objectMapper) {
        this.supplierConfig = supplierConfig;
        this.factory = factory;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void init() throws Exception {
        ObjectMapper objMapper = new ObjectMapper(new YAMLFactory());
        String path = supplierConfig.buildPath();
        System.out.println("path :::: "+path);
        String json = factory.read(path);
        ConfigDTO configDTO = objMapper.readValue(json, ConfigDTO.class);
        configDTOMap.put(1, configDTO);
    }

    public LotResponseDTO fetchSupplierDetails(String lotNo) {
        LotResponseDTO lotResponseDTO = new LotResponseDTO();
        try {
            ConfigDTO configDTO = configDTOMap.getOrDefault(1, new ConfigDTO());
            LotDetailsDTO lotDto = new LotDetailsDTO();
            lotResponseDTO.setCompanyAddress(configDTO.getLotDetails().getCompanyAddress());
            lotResponseDTO.setCompanyName(configDTO.getLotDetails().getCompanyName());
            lotResponseDTO.setLotNo(String.valueOf(configDTO.getLotDetails().getLots().getOrDefault(lotNo,lotDto).getLotNo()));
            lotResponseDTO.setMfgDate(String.valueOf(configDTO.getLotDetails().getLots().getOrDefault(lotNo,lotDto).getMfgDate()));
            lotResponseDTO.setManufacturerAddress(configDTO.getLotDetails().getLots().getOrDefault(lotNo,lotDto).getManufacturerAddress());
            lotResponseDTO.setManufacturedBy(configDTO.getLotDetails().getLots().getOrDefault(lotNo,lotDto).getMaufacturedBy());
            lotResponseDTO.setFssaiLicenseNo(configDTO.getLotDetails().getLots().getOrDefault(lotNo,lotDto).getFssaiLicenseNo());
            System.out.println("completing lot response dto");
        }
        catch (Exception e)
        {
            System.out.println("exception coming:::"+e);
            return new LotResponseDTO();
        }
        return lotResponseDTO;
    }
}

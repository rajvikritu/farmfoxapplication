package com.farmfox.farmfoxapp.controller;

import com.farmfox.farmfoxapp.entity.ConfigDTO;
import com.farmfox.farmfoxapp.entity.LotResponseDTO;
import com.farmfox.farmfoxapp.entity.SupplierDTO;
import com.farmfox.farmfoxapp.service.SupplierService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SupplierController {

    private final SupplierService supplierService;

    SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/supplier/lot")
    public ResponseEntity<LotResponseDTO> getSupplierDetails(@RequestParam("lotNo") String lotNo) {
        LotResponseDTO configDTO = supplierService.fetchSupplierDetails(lotNo);
        return ResponseEntity.status(HttpStatus.OK).body(configDTO);
    }
}

package com.farmfox.farmfoxapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierDTO {
    private String supplierName;
    private String productName;
    private String mfgDate;
    private String lotNo;
}

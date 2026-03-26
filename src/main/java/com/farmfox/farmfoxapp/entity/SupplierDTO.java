package com.farmfox.farmfoxapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierDTO {
    private String companyName;
    private String companyAddress;
    private String mfgDate;
    private String lotNo;
}

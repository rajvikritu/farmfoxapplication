package com.farmfox.farmfoxapp.entity;

import lombok.Data;

@Data
public class LotDetailsDTO {
    private String mfgDate;
    private String lotNo;
    private String maufacturedBy;
    private String manufacturerAddress;
    private String fssaiLicenseNo;
}

package com.farmfox.farmfoxapp.entity;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class SupplierDTO {
    private String companyName;
    private String companyAddress;
    private Map<String, LotDetailsDTO> lots = new HashMap<>();

    @JsonAnySetter
    public void addLot(String key, Object value) {

        if (value instanceof Map) {

            Map<?, ?> map =
                    (Map<?, ?>) value;
            LotDetailsDTO dto =
                    new LotDetailsDTO();

            dto.setMfgDate(
                    map.get("mfgDate")
                            .toString()
            );
            dto.setLotNo(
                    map.get("lotNo")
                            .toString()
            );
            dto.setManufacturerAddress(map.get("manufacturerAddress").toString());
            dto.setFssaiLicenseNo(map.get("fssaiLicenseNo").toString());
            dto.setMaufacturedBy(map.get("maufacturedBy").toString());
            lots.put(key, dto);
        }
    }
}

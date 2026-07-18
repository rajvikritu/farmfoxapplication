package com.farmfox.farmfoxapp.service.impl;

import com.farmfox.farmfoxapp.entity.ValueCombo;
import com.farmfox.farmfoxapp.service.ValueComboService;
import org.springframework.stereotype.Service;


@Service
public class ValueComboServiceImpl implements ValueComboService {
    @Override
    public ValueCombo getValueComboDetail() {
        return  new ValueCombo(
                1L,
                "Premium Nuts & Dry Fruits Combo",
                "https://cdn.farmfox.com/combo1.png",
                761.0,
                895.0,
                "1.3",
                5.0,
                5,
                true,
                true
        );
    }
}

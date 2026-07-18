package com.farmfox.farmfoxapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faq {
    private Integer id;
    private String question;
    private String answer;
}

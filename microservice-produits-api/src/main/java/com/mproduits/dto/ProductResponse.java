package com.mproduits.dto;



import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductResponse {

    private String title;

    private String description;

    private String image;

    private BigDecimal price;
}

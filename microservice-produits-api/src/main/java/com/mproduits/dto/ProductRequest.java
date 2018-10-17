package com.mproduits.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {
    // Ajout type de produt Enum

    private BigDecimal price;
}

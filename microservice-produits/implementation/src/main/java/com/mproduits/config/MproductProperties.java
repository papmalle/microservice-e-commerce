package com.mproduits.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("config-product")
@Getter
@Setter
public class MproductProperties {

    private int limite;
}

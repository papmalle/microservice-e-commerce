package com.mproducts;

import com.mproduits.config.ProductConfiguration;i
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ProductConfiguration.class)
public class MproduitsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MproduitsApplication.class, args);
    }

}

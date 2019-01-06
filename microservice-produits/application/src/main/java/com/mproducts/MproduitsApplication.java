package com.mproducts;

import com.mproduits.config.ProductConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@Import(ProductConfiguration.class)
public class MproduitsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MproduitsApplication.class, args);
    }

}

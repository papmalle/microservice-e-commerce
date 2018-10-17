package com.mproduits.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductFeignConfig {

//    surcharge du contrat Feign par défaut afin de :
    // - utiliser les annotations Feign plutot que celles de Spring MVC
    // - ajouter notre gestion du contexte de requête

    @Bean
    Contract feignContract(){
        return new feign.Contract.Default();
    }
}

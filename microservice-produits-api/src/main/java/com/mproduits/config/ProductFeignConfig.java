package com.mproduits.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*

@FeignClient(name= ProductApiConstant.SERVICE_NAME, configuration = ProductFeignConfig.class)

Pas Obliger de mettre configuration = ProductFeignConfig.class dans l'productApi car il est scanner automatiquement grace @Configuration

    On a une importe de toute cette dependance (ProductApi snaphot) dans SpringBootTuto c'est comme si on
    a creer toutes ces classes dans le projet SpringBootTuto
*/
@Configuration
public class ProductFeignConfig {

//    surcharge du contrat Feign par défaut afin de :
    // - utiliser les annotations Feign plutot que celles de Spring MVC
    // - ajouter notre gestion du contexte de requête

    @Bean
    Contract feignContract() {
        return new feign.Contract.Default();
    }

    /**
     * Quand il y'aura une erreur , plutot que d'utiliser une errorDecodeur classique de feign
     * on va utiliser celui ci qui implement errorDecodeur initiale
     *
     * @return
     */
    @Bean
    ProductFeignErrorDecoder mProductFeignErrorDecoder() {
        return new ProductFeignErrorDecoder();
    }
}

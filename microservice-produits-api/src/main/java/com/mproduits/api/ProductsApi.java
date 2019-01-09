package com.mproduits.api;

import com.mproduits.config.ProductFeignConfig;
import com.mproduits.constant.ProductApiConstant;
import com.mproduits.dto.ProductRequest;
import com.mproduits.dto.ProductResponse;
import com.mproduits.exception.ProductNotFoundException;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

// Ceci est un proxy feign qui est une interface qui fournit toutes les informations à feign pour recuperer
// ou generer des reqêtes https (dans openclassroom Optimisation MS, ils ont definie cette interface dans le client appelant or ici on a mis dans l'api (une autre module) qui aura une dependance dans l'app client appelant
/*
 name= ProductApiConstant.SERVICE_NAME  se retouve dans application.yml du module APPLICATION du MS ,
        dans application.yml de springBootTuto j'ai defini :
        #C'est le ribbon qui est utilisé dans l'annotation @FeignClient dans Product-Api
        products-service:
        ribbon:
        listOfServers: http://localhost:9001'


        Le nom de Ribbon est egal au Nom de l'application enregistré dans Eureka
*/

//// J'ai redefini le feign contrat dans ProductFeignConfig.class pour utiliser requestLine au lieu du GetMapping sur les methodes OU SOIT TU LE DEFINI DANS LA CONF DU DE L APP CLIENT APPELANT VOIR EC feign config

//@FeignClient(name= ProductApiConstant.SERVICE_NAME, configuration = ProductFeignConfig.class)
@FeignClient(name = ProductApiConstant.SERVICE_NAME)
public interface ProductsApi {
    @RequestLine("GET " + ProductApiConstant.PATH_PRODUCT)
//    @RequestLine("GET " + ProductApiConstant.PATH_PRODUCT)
    List<ProductResponse> getProducts() throws ProductNotFoundException;

    @RequestLine("POST " + ProductApiConstant.PATH_PRODUCT)
    List<ProductResponse> getProductsByPrice(ProductRequest productRequest) throws ProductNotFoundException;

    @RequestLine("GET " + ProductApiConstant.PATH_PRODUCT_BY_ID + "{" + ProductApiConstant.ID_PRODUCT + "}")
    ProductResponse getProduct(@Param(ProductApiConstant.ID_PRODUCT) Integer id) throws ProductNotFoundException;

}

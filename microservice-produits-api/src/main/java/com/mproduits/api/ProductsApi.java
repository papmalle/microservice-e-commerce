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
// J'ai redefini le feign contrat dans ProductFeignConfig.class pour utiliser requestLine au lieu du GetMapping sur les methodes OU SOIT TU LE DEFINI DANS LA CONF DU DE L APP CLIENT APPELANT VOIR EC feign config
@FeignClient(name= ProductApiConstant.SERVICE_NAME, configuration = ProductFeignConfig.class)
public interface ProductsApi {
    @RequestLine("GET " + ProductApiConstant.PATH_PRODUCT)
    List<ProductResponse> getProducts() throws ProductNotFoundException;

    @RequestLine("POST " + ProductApiConstant.PATH_PRODUCT)
    List<ProductResponse> getProductsByPrice(ProductRequest productRequest) throws ProductNotFoundException;

    @RequestLine("GET " + ProductApiConstant.PATH_PRODUCT_BY_ID + "{" + ProductApiConstant.ID_PRODUCT + "}")
    ProductResponse getProduct(@Param(ProductApiConstant.ID_PRODUCT) Integer id) throws ProductNotFoundException;

}

package com.mproducts.controller;

import com.mproduits.constant.ProductApiConstant;
import com.mproduits.dto.ProductRequest;
import com.mproduits.dto.ProductResponse;
import com.mproduits.exception.ProductNotFoundException;
import com.mproduits.facade.ProductsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsFacade productsFacade;

    @GetMapping(ProductApiConstant.PATH_PRODUCT)
    public List<ProductResponse> getProducts() throws ProductNotFoundException {
        return productsFacade.getProducts();
    }

    @GetMapping(ProductApiConstant.PATH_PRODUCT_BY_ID + "{" + ProductApiConstant.ID_PRODUCT + "}")
    public ProductResponse getProduct(@PathVariable() Integer id) {
        return productsFacade.getProduct(id);
    }


    @PostMapping(ProductApiConstant.PATH_PRODUCT)
    public List<ProductResponse> getProductsByPrice(@RequestBody ProductRequest productRequest) {
        return productsFacade.getProductsByPrice(productRequest);
    }
}

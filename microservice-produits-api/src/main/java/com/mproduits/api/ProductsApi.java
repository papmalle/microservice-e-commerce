package com.mproduits.api;

import com.mproduits.dto.ProductResponse;
import com.mproduits.exception.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.List;

public interface ProductsApi {

    List<ProductResponse> getProducts() throws ProductNotFoundException;

    List<ProductResponse> getProductsByPrice(BigDecimal price) throws ProductNotFoundException;

    ProductResponse getProductById(Integer id) throws ProductNotFoundException;

}

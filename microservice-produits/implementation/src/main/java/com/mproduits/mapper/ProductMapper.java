package com.mproduits.mapper;

import com.mproduits.dto.ProductResponse;
import com.mproduits.entity.Product;

public class ProductMapper {

   public static ProductResponse convertProductsToProductsResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setDescription(product.getDescription());
        response.setImage(product.getImage());
        response.setTitle(product.getTitle());
        response.setPrice(product.getPrice());
        return response;
    }
}

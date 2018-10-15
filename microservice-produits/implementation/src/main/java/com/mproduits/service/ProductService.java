package com.mproduits.service;

import com.mproduits.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<Product> findAllProduct();

    Product findOneProduct(Integer id);

    List<Product> findProductByPrice(BigDecimal price);

}

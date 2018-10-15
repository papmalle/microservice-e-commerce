package com.mproducts;

import com.mproduits.dto.ProductResponse;
import com.mproduits.exception.ProductNotFoundException;
import com.mproduits.facade.ProductsFacade;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductsController {

    private final ProductsFacade productsFacade;

    @GetMapping("/products")
    public List<ProductResponse> getProducts() throws ProductNotFoundException {
        return productsFacade.getProducts();
    }

    @GetMapping("products/{id}")
    public ProductResponse getProduct(@PathVariable() Integer id) {
        return productsFacade.getProductById(id);
    }


    @GetMapping("product/{price}")
    List<ProductResponse> getProductByPrice(@PathVariable BigDecimal price) {
        return productsFacade.getProductsByPrice(price);
    }
}

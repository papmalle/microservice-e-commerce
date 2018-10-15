package com.mproduits.facade;

import com.mproduits.api.ProductsApi;
import com.mproduits.dto.ProductResponse;
import com.mproduits.entity.Product;
import com.mproduits.exception.ProductNotFoundException;
import com.mproduits.mapper.ProductMapper;
import com.mproduits.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductsFacade implements ProductsApi {
    private final ProductService productService;

    @Override
    public List<ProductResponse> getProducts() throws ProductNotFoundException {
        final List<Product> products = productService.findAllProduct();
        checkProducts(products);
        return products.stream()
                .map(ProductMapper::convertProductsToProductsResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> getProductsByPrice(BigDecimal price) throws ProductNotFoundException {
        final List<Product> products = productService.findProductByPrice(price);
        checkProducts(products);
        return products.stream()
                .map(ProductMapper::convertProductsToProductsResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(Integer id) throws ProductNotFoundException {
        final Product oneProduct = productService.findOneProduct(id);
        return ProductMapper.convertProductsToProductsResponse(oneProduct);
    }

    private void checkProducts(List<Product> products) {
        if (products.isEmpty()) {
            throw new ProductNotFoundException("Products Not found");
        }
    }
}

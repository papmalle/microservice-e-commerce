package com.mproduits.facade;

import com.mproduits.api.ProductsApi;
import com.mproduits.config.MproductProperties;
import com.mproduits.dto.ProductRequest;
import com.mproduits.dto.ProductResponse;
import com.mproduits.entity.Product;
import com.mproduits.exception.ProductNotFoundException;
import com.mproduits.mapper.ProductMapper;
import com.mproduits.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductsFacade implements ProductsApi {
    private final ProductService productService;
    private final MproductProperties mproductProperties;

    @Override
    public List<ProductResponse> getProducts() throws ProductNotFoundException {
        final List<Product> products = productService.findAllProduct();
        final int limite = mproductProperties.getLimite();
        checkProducts(products);
        return products.stream()
                .map(ProductMapper::convertProductsToProductsResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> getProductsByPrice(ProductRequest productRequest) throws ProductNotFoundException {
        final BigDecimal price = productRequest.getPrice();
        final List<Product> products = productService.findProductByPrice(price);
        checkProducts(products);
        return products.stream()
                .map(ProductMapper::convertProductsToProductsResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProduct(Integer id) throws ProductNotFoundException {
        final Product oneProduct = productService.findOneProduct(id);
        return ProductMapper.convertProductsToProductsResponse(oneProduct);
    }

    private void checkProducts(List<Product> products) {
        if (!products.isEmpty()) {
            throw new ProductNotFoundException("Products Not found");
        }
    }
}

package com.example.backangular.service;

import java.util.List;
import java.util.stream.Collectors;

import com.mproduits.api.ProductsApi;
import com.mproduits.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductsApi productsApi;

    @Override
    public List<ProductResponse> getAppareilProduct() {
        return productsApi.getProducts()
                .stream()
                .limit(1)
                .collect(Collectors.toList());
    }
}

package com.mproduits.service;

import com.mproduits.entity.Product;
import com.mproduits.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findOneProduct(Integer id) {

        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findProductByPrice(BigDecimal price) {
        return productRepository.findProductByPrice(price);
    }
}

package com.example.springsecuritybasicflow.service;

import com.example.springsecuritybasicflow.entity.Product;
import com.example.springsecuritybasicflow.model.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}

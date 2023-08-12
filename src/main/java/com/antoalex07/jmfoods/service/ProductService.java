package com.antoalex07.jmfoods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antoalex07.jmfoods.model.Product;
import com.antoalex07.jmfoods.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> allProducts(){
        return productRepository.findAll();
    }
    
}

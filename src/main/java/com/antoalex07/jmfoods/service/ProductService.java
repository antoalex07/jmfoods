package com.antoalex07.jmfoods.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
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

    public Optional<Product> findProduct(ObjectId id){
        return productRepository.findById(id);
    }

    public Product createProduct(Product product){
        
        Product prod = new Product();
        
        prod.setProductName(product.getProductName());
        prod.setInStock(product.isInStock());
        prod.setDescription(product.getDescription());
        prod.setPrice(product.getPrice());
        
        productRepository.insert(prod);

        return prod;
    }
    
}

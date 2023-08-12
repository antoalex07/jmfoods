package com.antoalex07.jmfoods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antoalex07.jmfoods.model.Product;
import com.antoalex07.jmfoods.service.ProductService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>(productService.allProducts(), HttpStatus.OK);
    }

    // @PostMapping
    // public ResponseEntity<Product> createProduct(@RequestBody Product product){
        
    // }
}

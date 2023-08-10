package com.antoalex07.jmfoods.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.antoalex07.jmfoods.model.Product;

public interface ProductRepository extends MongoRepository<Product, ObjectId>{
    
}

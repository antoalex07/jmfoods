package com.antoalex07.jmfoods.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    
    @Id
    @GeneratedValue
    @JsonIgnore
    private ObjectId id;
    
    private String productName;
    private boolean inStock;
    private String description;
    private int price;

    public Product(String productName, boolean inStock, String description, int price){
        this.productName = productName;
        this.inStock = inStock;
        this.description = description;
        this.price = price;
    }

}

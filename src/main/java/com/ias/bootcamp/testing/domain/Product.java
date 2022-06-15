package com.ias.bootcamp.testing.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer price;
    private Integer typeOfProduct;

    public Product(String name, Integer price, Integer typeOfProduct) {
        this.name = name;
        this.price = price;
        this.typeOfProduct = typeOfProduct;
    }

    public Product (){ }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(Integer typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }
}

package com.ias.bootcamp.testing.controller;


import com.ias.bootcamp.testing.Service.ProductService;
import com.ias.bootcamp.testing.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

}

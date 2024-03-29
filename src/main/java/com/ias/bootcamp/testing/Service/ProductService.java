package com.ias.bootcamp.testing.Service;

import com.ias.bootcamp.testing.domain.Product;
import com.ias.bootcamp.testing.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getProducts() { return productRepository.findAll(); }
}

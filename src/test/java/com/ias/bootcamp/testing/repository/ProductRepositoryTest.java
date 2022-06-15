package com.ias.bootcamp.testing.repository;

import com.ias.bootcamp.testing.domain.Product;
import com.ias.bootcamp.testing.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void saveProductSuccess() {
        Product product = new Product("Tv", 50000, 1);


        Product savedProduct = productRepository.save(product);
        Optional<Product> queryProduct = productRepository.findById(savedProduct.getId());


        assertNotNull(savedProduct);
        assertEquals(savedProduct.getName(), queryProduct.get().getName());
    }

    @Test
    void queryProduct(){
        Product product = new Product("PS5", 458479, 1);
        Product product1 = new Product("Screen", 7645655, 1);
        Product product2 = new Product("Laptop", 7875676, 2);

        Product savedProduct = productRepository.save(product);
        Product savedProduct1 = productRepository.save(product1);
        Product savedProduct2 = productRepository.save(product2);

        Optional<Product> queryProduct = productRepository.findById(savedProduct1.getId());


        assertNotNull(queryProduct);
        assertEquals(queryProduct.get().getName(), savedProduct1.getName());
    }
}

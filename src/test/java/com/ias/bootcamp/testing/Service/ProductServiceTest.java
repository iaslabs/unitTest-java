package com.ias.bootcamp.testing.Service;

import com.ias.bootcamp.testing.domain.Product;
import com.ias.bootcamp.testing.repositories.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService service;

    @Test
    @DisplayName("Save product complete")
    void saveProduct(){
        Product product = new Product("Laptop", 5000000, 1);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product result = service.saveProduct(product);

        assertNotNull(result);
        assertEquals("Laptop", result.getName());
    }
}
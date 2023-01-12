package com.ias.bootcamp.testing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ias.bootcamp.testing.Service.ProductService;
import com.ias.bootcamp.testing.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Save product completed")
    void saveProduct() throws Exception {
        //Preparación datos
        Product product = new Product("Headphones", 500000, 1);
        when(productService.saveProduct(any(Product.class))).thenReturn(product);
        ObjectMapper mapper = new ObjectMapper();


        //validación
        this.mockMvc.perform(post("/api/product").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(product)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Headphones")));

    }

    @Test
    @DisplayName("Get products ok")
    void getProductsOk() throws Exception {
        //Arrange
        Product product = new Product("Headphones", 500000, 1);
        when(productService.getProducts()).thenReturn(List.of(product));


        //Act & Assert
        this.mockMvc.perform(get("/api/product").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content().string(containsString("Headphones")));
    }

}
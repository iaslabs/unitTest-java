package com.ias.bootcamp.testing.repositories;

import com.ias.bootcamp.testing.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

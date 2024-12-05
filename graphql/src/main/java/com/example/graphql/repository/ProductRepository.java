package com.example.graphql.repository;

import com.example.graphql.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product getByName(String name);
}

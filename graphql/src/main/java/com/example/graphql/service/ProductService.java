package com.example.graphql.service;

import com.example.graphql.model.Product;
import com.example.graphql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getById(Integer id) {
        return productRepo.findById(id);
    }

    public Product getByName(String name) {
        return productRepo.getByName(name);
    }

    public Product postProducts(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(Integer id, Product product) {
        Optional<Product> existingProduct = productRepo.findById(id);
        if (existingProduct.isEmpty()) {
            throw new RuntimeException("Product not found with id " + id);
        }
        product.setId(id); // Update the product with the correct ID
        return productRepo.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepo.deleteById(id);
    }
}


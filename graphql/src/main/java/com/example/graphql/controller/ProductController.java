package com.example.graphql.controller;

import com.example.graphql.model.Product;
import com.example.graphql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    //query to get all products
    @QueryMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    // Query to get a product by ID
    @QueryMapping
    public Optional<Product> productById(@Argument Integer id) {
        return productService.getById(id);
    }

    //query to get products by name
    @QueryMapping
    public Product getByName(@Argument String name) {
        return productService.getByName(name);
    }

    // Mutation to create a new product
    @MutationMapping
    public Product createProduct(@Argument String name,
                                 @Argument String category,
                                 @Argument Integer stock,
                                 @Argument Float price,
                                 @Argument String description) {
        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setStock(stock);
        product.setDescription(description);
        product.setPrice(price);
        return productService.postProducts(product);
    }

    // Mutation to update a product by ID
    @MutationMapping
    public Product updateProduct(@Argument Integer id,
                                 @Argument String name,
                                 @Argument String category,
                                 @Argument Integer stock,
                                 @Argument Float price,
                                 @Argument String description) {
        Product product = new Product(id, name, category, price, stock, description);
        return productService.updateProduct(id, product);
    }

    // Mutation to delete a product by ID
    @MutationMapping
    public String deleteProduct(@Argument Integer id) {
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }

}


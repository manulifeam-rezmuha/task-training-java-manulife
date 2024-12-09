package com.training_java.services;

import com.training_java.models.Product;
import com.training_java.repositories.ProductRepository;
import com.training_java.utils.errorHandling;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // get all list of Product
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // get Product by id
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // create or add product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // update product by id
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new errorHandling(HttpStatus.NOT_FOUND, "Product not found!" + id));

        product.setName(productDetails.getName());
        productDetails.setPrice(productDetails.getPrice());

        return  productRepository.save(product);
    }

    // delete product by id
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new errorHandling(HttpStatus.NOT_FOUND, "Product not found!" + id));

        productRepository.delete(product);
    }
}

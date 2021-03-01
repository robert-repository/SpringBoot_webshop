package com.webshop.webshop.Service;

import com.webshop.webshop.Domain.Product;
import com.webshop.webshop.Domain.Stock;
import com.webshop.webshop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void addProduct(String productNumber, String description, double price) {
        Product product = new Product(productNumber, description,  price);
        productRepository.save(product);

    }
    public Product getProduct(String productNumber) {
        Optional<Product> result = productRepository.findById(productNumber);
        if (result.isPresent())
            return result.get();
        else
            return null;
    }
    public void setStock(String productNumber, int quantity, String locationCode) {
        Optional<Product> result = productRepository.findById(productNumber);
        if (result.isPresent()) {
            Product product = result.get();
            Stock stock = new Stock(quantity, locationCode);
            product.setStock(stock);
            productRepository.save(product);
        }
    }

}

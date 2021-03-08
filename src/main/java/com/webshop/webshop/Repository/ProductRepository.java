package com.webshop.webshop.Repository;

import com.webshop.webshop.Domain.Shopping.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}

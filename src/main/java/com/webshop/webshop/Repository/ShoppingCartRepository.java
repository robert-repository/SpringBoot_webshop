package com.webshop.webshop.Repository;

import com.webshop.webshop.Domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart,String> {
}

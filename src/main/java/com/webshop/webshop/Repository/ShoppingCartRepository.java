package com.webshop.webshop.Repository;

import com.webshop.webshop.Domain.Shopping.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart,String> {
}

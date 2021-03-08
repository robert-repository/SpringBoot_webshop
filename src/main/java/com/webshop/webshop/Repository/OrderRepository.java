package com.webshop.webshop.Repository;

import com.webshop.webshop.Domain.Order.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}

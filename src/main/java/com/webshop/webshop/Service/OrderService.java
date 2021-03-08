package com.webshop.webshop.Service;

import com.webshop.webshop.Domain.Order.Order;
import com.webshop.webshop.Domain.Order.OrderFactory;
import com.webshop.webshop.Domain.Shopping.ShoppingCart;
import com.webshop.webshop.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order getOrder(String orderNumber) {
        Optional<Order> optOrder = orderRepository.findById(orderNumber);
        return optOrder.orElse(null);
    }

    public void createOrder(ShoppingCart cart) {
        Order order = OrderFactory.createOrder(cart);
        orderRepository.save(order);
    }
}

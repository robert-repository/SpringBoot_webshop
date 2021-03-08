package com.webshop.webshop.Domain.Order;

import com.webshop.webshop.Domain.Shopping.Cart;
import com.webshop.webshop.Domain.Shopping.Product;
import com.webshop.webshop.Domain.Shopping.ShoppingCart;

import java.util.Date;

public class OrderFactory {
    public static Order createOrder(ShoppingCart cart) {
        Order order = new Order(cart.getCardId(), new Date(), "ordered");
        for (Cart cline : cart.getCartArrayList()) {
            OrderLine oline = new OrderLine();
            //create an order product from a shopping product
            Product product = new Product(cline.getProduct().getProductNumber(), cline.getProduct().getDescription(), cline.getProduct().getPrice());
            oline.setProduct(product);
            oline.setQuantity(cline.getQuantity());
            order.addOrderLine(oline);
        }
        return order;
    }
}

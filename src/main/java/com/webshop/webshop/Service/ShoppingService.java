package com.webshop.webshop.Service;

import com.webshop.webshop.Domain.Product;
import com.webshop.webshop.Domain.ShoppingCart;
import com.webshop.webshop.Repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingService {
    @Autowired
    ProductService productService;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    public void addToCart(String cartId, String productNumber, int quantity) {
        Product product = productService.getProduct(productNumber);
        Optional<ShoppingCart> cartOptional = shoppingCartRepository.findById(cartId);
        if (cartOptional.isPresent() && product != null) {
            ShoppingCart cart = cartOptional.get();
            cart.addToCart(product, quantity);
            shoppingCartRepository.save(cart);
        }
        else if (product != null) {
            ShoppingCart cart = new ShoppingCart();
            cart.setCardId(cartId);
            cart.addToCart(product, quantity);
            shoppingCartRepository.save(cart);
        }
    }

    public ShoppingCart getCart(String cartId) {
        Optional<ShoppingCart> cart = shoppingCartRepository.findById(cartId);
        if (cart.isPresent())
            return cart.get();
        else
            return null;
    }
}

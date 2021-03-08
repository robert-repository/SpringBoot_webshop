package com.webshop.webshop.Domain.Shopping;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Iterator;

@Document
public class ShoppingCart {
    @Id
    String cardId;

    ArrayList<Cart> cartArrayList = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        for (Cart c : cartArrayList) {
            if (c.getProduct().getProductNumber().equals(product.getProductNumber())) {
                c.setQuantity(c.getQuantity()+quantity);
                return;
            }
        }
        Cart c = new Cart();
        c.setProduct(product);
        c.setQuantity(quantity);
        cartArrayList.add(c);
    }

    public void print() {
        System.out.println("My shoppingCart:");
        for (Cart c : cartArrayList) {
            System.out.println(c.getQuantity() + " "
                    + c.getProduct().getProductNumber() + " "
                    + c.getProduct().getDescription() + " "
                    + c.getProduct().getPrice());
        }
        System.out.println("Total = "+getTotalPrice());
    }

    public double getTotalPrice(){
        double totalPrice = 0.0;
        for (Cart c : cartArrayList) {
            totalPrice=totalPrice+(c.getProduct().getPrice() * c.getQuantity());
        }
        return totalPrice;
    }

    public void removeFromCart(Product product){
        Iterator<Cart> iter = cartArrayList.iterator();
        while (iter.hasNext()){
            Cart c = iter.next();
            if (c.getProduct().getProductNumber().equals(product.getProductNumber())){
                if (c.getQuantity()>1){
                    c.setQuantity(c.getQuantity()-1);
                }
                else{
                    iter.remove();
                }
            }
        }
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public ArrayList<Cart> getCartArrayList() {
        return cartArrayList;
    }

    public void setCartArrayList(ArrayList<Cart> cartArrayList) {
        this.cartArrayList = cartArrayList;
    }
}

package com.webshop.webshop.Domain.Product;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Stock {
    private int quantity;
    private String locationCode;

    public Stock(int quantity, String locationCode) {
        this.quantity = quantity;
        this.locationCode = locationCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public void print() {
        System.out.println("Stock quantity: " + quantity + " , location code : " + locationCode);
    }
}

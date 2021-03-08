package com.webshop.webshop.Domain.Order;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private String orderNumber;
    private Date date;
    private String status;
    private ArrayList<OrderLine> orderLineList = new ArrayList<>();

    public Order() {
    }

    public Order(String orderNumber, Date date, String status) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.status = status;
    }

    public void print() {
        System.out.println("Your order:");
        System.out.println("OrderNumber :" + orderNumber + " , Date : " + date + " , Status : " + status);
        for (OrderLine oLine : orderLineList) {
            System.out.println(oLine.getQuantity() + " " + oLine.getProduct().getProductNumber() + " "
                    + oLine.getProduct().getDescription() + " " + oLine.getProduct().getPrice());
        }
        System.out.println("Total price =" + getTotalPrice());
    }

    private double getTotalPrice() {
        double totalPrice = 0.0;
        for (OrderLine oline : orderLineList) {
            totalPrice = totalPrice + (oline.getProduct().getPrice() * oline.getQuantity());
        }
        return totalPrice;
    }

    public void addOrderLine(OrderLine oline) {
        orderLineList.add(oline);
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(ArrayList<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }
}

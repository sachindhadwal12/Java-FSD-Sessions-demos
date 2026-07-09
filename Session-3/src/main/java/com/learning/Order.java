package com.learning;

import java.util.ArrayList;
import java.util.List;

public class Order {
    int orderId;
    List<OrderItem> items;

    public Order(int orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
    }

    public void addItem(String itemName,int quantity, int price){
        items.add(new OrderItem(itemName,quantity,price));
    }

    public void displayOrder(){
        System.out.println("Order Id :"+ orderId);
        for(OrderItem item : items){
            item.displayDetails();
        }
    }

}

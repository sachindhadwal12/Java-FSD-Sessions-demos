package com.learning;

public class OrderItem {

    String productName;
    int quantity;
    int price;

    public OrderItem(String productName, int quantity, int price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public void displayDetails(){
        System.out.println("Product Name is "+ productName);
        System.out.println("Price is :" + price);
        System.out.println("Quantity is :" + quantity);
    }


}

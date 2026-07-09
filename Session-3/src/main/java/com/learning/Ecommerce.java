package com.learning;

public class Ecommerce {
    static void main() {
        Order order = new Order(1001);
        order.addItem("Laptop",1,50000);
        order.addItem("Mouse",2,500);

        order.displayOrder();
    }
}

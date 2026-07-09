package com.learning.Thread;

public class TicketBooking {
    int ticketavailable = 5;

    public synchronized void bookTicket(String customerName, int tickets) {
        if(ticketavailable >= tickets) {
            System.out.println(customerName + "  is booking " + tickets + "  tickets");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticketavailable -= tickets;
            System.out.println(customerName + " Booking successful");
            System.out.println("Remaining Tickets" + ticketavailable);
        }
        else {
            System.out.println("Booking Failed");
            System.out.println("Remaining Tickets" + ticketavailable);
        }
    }
}
class  Demo{
    static void main() throws InterruptedException {
        TicketBooking booking = new TicketBooking();
        Thread t1 = new Thread(()->booking.bookTicket("Rahul",2));
        Thread t2 = new Thread(()->booking.bookTicket("Priya",2));
        Thread t3 = new Thread(()->booking.bookTicket("Gopal",2));


        t1.start();
        t2.start();
        t3.start();

//        booking.bookTicket("Rahul",2);
//        booking.bookTicket("Anjali",2);
//        booking.bookTicket("Vishal",2);
//        Thread t1 = new Thread();
//        Thread t2 = new Thread();
    }
}

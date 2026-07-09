package com.learning.Thread;

public class MyRunnableDemo implements Runnable {
    @Override
    public synchronized void run() {
        for(int i=0;i<=5;i++){
            System.out.println(Thread.currentThread().getName()+ "  "+i);
        }
    }

    static void main() {
        MyRunnableDemo demo = new MyRunnableDemo();
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
        t1.start();
        t2.start();
    }
}

package com.learning.Thread;


class Display{
    public synchronized void displayData(){
        for(int i=0;i<=5 ;i++){
            System.out.println(Thread.currentThread().getName() +"  "+i);
        }
    }
}

public class MyThread extends Thread{

 Display display;

 MyThread(Display display, String name){
     this.display = display;
     setName(name);
 }

    @Override
    public void run() {
        display.displayData();
    }


    static void main() {
     // shared object
        Display display1 = new Display();

        MyThread t1 = new MyThread(display1,"Thread-A");
        MyThread t2 = new MyThread(display1,"Thread-B");
       // acquire the lock
        // wait until  T1
        // lock will release
        t1.start();
        t2.start();

    }
    //        t1.setName("Sachin");
//        System.out.println(t1.getName());
//        t2.start();
//        t2.setName("Rahul");
//        System.out.println(t2.getName());
    }


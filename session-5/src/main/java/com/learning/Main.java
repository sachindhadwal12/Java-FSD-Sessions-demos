package com.learning;

import java.io.FileInputStream;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Scanner scanner = new Scanner(System.in);
        int age ;

        System.out.println("Enter the age");
        age = scanner.nextInt();

        int result = age/0;
        System.out.println(result);





//        ArrayDeque<String> stack = new ArrayDeque<>();
//        stack.push("Sachin");
//        stack.push("Gopal");
//        stack.push("Ramesh");
//        System.out.println(stack);
//        stack.addFirst("Mohit");

//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
     //   System.out.println(stack);

//        Map<Integer,String> map = new HashMap<>();
//        map.put(5,"Java");
//        map.put(1,"C++");
//        map.put(3,"Python");
//        map.put(2,"React");
//        map.put(4,"Spring");
//        System.out.println(map);
//
//        System.out.println(map.get(3));
//        map.remove(3);
//        System.out.println(map.size());
//
//        boolean result = map.containsKey(14);
//        System.out.println(result);
//        System.out.println(map.isEmpty());
//
//        System.out.println(map);
//
//        for(Map.Entry<Integer,String> entry : map.entrySet()){
//            System.out.println(entry.getKey()+"   "+entry.getValue());
//        }

//        Queue<String> queue = new PriorityQueue<>();
//        queue.add("Sachin");
//        queue.add("Gopal");
//        queue.add("Mohit");
//        queue.add("Rohit");

      //  queue.poll();


//        System.out.println(queue.peek());
//        System.out.println(queue.size());
//
//        for(String obj: queue){
//            System.out.println(obj);
//        }


//Iterator iterator = queue.iterator();
//while (iterator.hasNext()){
//    System.out.println(iterator.next());
//}


    }
}

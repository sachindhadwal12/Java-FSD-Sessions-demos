package com.learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    static void main() {
        List<String> list = new LinkedList<>();
        list.add("Sachin");
       list.add("Gopal");
       list.add("Sachin");
       list.add("Ramesh");
       list.add("Mohit");

        System.out.println(list.size());
    }
}

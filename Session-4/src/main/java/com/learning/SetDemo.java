package com.learning;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    static void main() {
        Set <String>  set = new TreeSet<>();
        set.add("Sachin");
        set.add("Gopal");
        set.add("Sachin");
        set.add("Mohit");
        System.out.println(set);
    }
}

package com.learning;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {


        String data = "I won the match 3 times";
        Pattern pattern = Pattern.compile("won");
        Matcher matcher = pattern.matcher(data);
        if(matcher.find()){
          String result =  matcher.replaceAll("lost");
            System.out.println(result);
        }
        else {
            System.out.println("Value not found");
        }
    }
}

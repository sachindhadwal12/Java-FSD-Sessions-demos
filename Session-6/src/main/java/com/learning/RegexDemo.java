package com.learning;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {


    private  static  final String regex ="^(0|91)?[6-9][0-9]{9}$";

    private static  final  Pattern pattern = Pattern.compile(regex);


    public static boolean isValidMobile(String number){
        if(number==null){
            return  false;
        }
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }



    static void main() {
//        Pattern pattern = Pattern.compile("Java");
//        Matcher  matcher = pattern.matcher("Java Programming");
//        if(matcher.find()){
//            System.out.println("Pattern Found"+ matcher.group());
//        }
//        else {
//            System.out.println("Not found");
//        }


        System.out.println(isValidMobile("7777788888"));
        System.out.println(isValidMobile("917777788888"));
        System.out.println(isValidMobile("5777788888"));


    }
}

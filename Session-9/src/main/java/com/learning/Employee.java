package com.learning;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

public class Employee {
    static void main() {

        LocalDate date = LocalDate.now();
        DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
        String d = date.format(formatter);
        System.out.println("new format"+d);









//        Date date = new Date();

//        System.out.println(date);
//
//        LocalDate date1 = LocalDate.now();
//        System.out.println(date1.getDayOfMonth());
//        System.out.println(date1.getMonth());
//        System.out.println(date1.getDayOfYear());
//
//
//        System.out.println(date1.plusDays(5));
//
//        System.out.println(date1.plusYears(1));
//
//        LocalTime time = LocalTime.now();
//        System.out.println(time);
//
//        System.out.println(time.getMinute());
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//       String d = time.format(formatter);
//        System.out.println(d);
//


//        ZonedDateTime india = ZonedDateTime.now();
//        System.out.println(india);

         ZonedDateTime usa = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(usa);



//        String name = null;
//        Optional<String> optionalName = Optional.ofNullable(name);

//        String result = optionalName.orElse("Ravi");
//        System.out.println(result);

//        String result = optionalName.orElseThrow(()-> new RuntimeException("Name not FOund"));




//         if(optionalName.isPresent()){
//             System.out.println("Name is "+ optionalName.get());
//         }
//         else{
//             System.out.println("Value is empty");
//         }


       // System.out.println(name.length());
    }





}

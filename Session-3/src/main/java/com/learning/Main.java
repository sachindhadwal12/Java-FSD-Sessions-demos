package com.learning;



//class College{
//    String collegeName;
//    College(String name){
//        this.collegeName = name;
//    }
//
//    @Override
//    public String toString() {
//        return "College{" +
//                "collegeName='" + collegeName + '\'' +
//                '}';
//    }
//}

//class Student{
//    String name;
//    College college;
//
//    public Student(String name, College college) {
//        this.name = name;
//        this.college = college;
//    }
//    public void displayData(){
//        System.out.println("Student Name is :"+name);
//        System.out.println("College Name is "+ college.collegeName);
//    }
//}


import com.learning.employees.Employee;

public class Main {
    static void main() {

//        College obj1 = new College("GPS");
//        Student student = new Student("Ravi",obj1);
//        student.displayData();


        Calculator calculator = new Calculator();
        System.out.println(   calculator.add(10,20));
        System.out.println(  calculator.add(10.5,20.5));
        System.out.println( calculator.add(2,3,5));


        Animal   animal  = new Dog();
           animal.sound();

     //   Employee employee = new Employee();
    }
}

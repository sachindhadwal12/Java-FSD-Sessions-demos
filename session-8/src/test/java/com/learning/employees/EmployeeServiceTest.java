package com.learning.employees;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    EmployeeService service ;

    Employee employee ,emp1;

    @BeforeEach
    void setUp(){
        employee = new Employee(101,"Sachin",60000);
        emp1 = new Employee(102,"Rahul",30000);
        System.out.println("I am before each method");
    }

    @AfterAll
   static void tearDown(){
        System.out.println("I am AfterALLL method");
    }
    @RepeatedTest(3)
    @DisplayName("Check Employee Bonus")

    public void testCalculateBonusForSalary(){

        service = new EmployeeService();
        double bonus = service.calculateBonus(employee);

        assertEquals(6000,bonus,"Bonus is 10% of actual Salary");
    }

    @Test
    @Disabled
    public void ShouldReturn5percentageofSalary(){
        service = new EmployeeService();
        double bonus = service.calculateBonus(emp1);
        assertEquals(1500,bonus);
    }

}
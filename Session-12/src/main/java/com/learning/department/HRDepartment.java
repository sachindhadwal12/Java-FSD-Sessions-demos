package com.learning.department;

import org.springframework.stereotype.Component;

@Component("hrDept")
public class HRDepartment implements Department{

    public HRDepartment(){
        System.out.println("HR Department Bean Created");
    }

    @Override
    public String getDepartment() {
        return "HR Department";
    }

}

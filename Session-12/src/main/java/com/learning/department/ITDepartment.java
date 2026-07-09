package com.learning.department;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("ITdept")
@Primary
public class ITDepartment implements Department{
    @Override
    public String getDepartment() {
        return "IT Department";
    }
    public ITDepartment(){
        System.out.println("IT Department Bean Created");
    }
}

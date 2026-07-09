package com.learning;

import com.testing.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan({"com.learning"})
public class MyConfig {

    @Bean
    public Hobby hobby(){
        return new Hobby("Chess","03-04-2022");
    }
    @Bean
    public Hobby hobby1(){
        return new Hobby("VolleyBall","03-04-2012");
    }

    @Bean
    public Address address(){
        return new Address("Goa","India");
    }


    @Bean
    public Student student(){
        return new Student("Sachin","sachin@gmail.com",
                Arrays.asList(hobby(),hobby1()),address());
    }
}

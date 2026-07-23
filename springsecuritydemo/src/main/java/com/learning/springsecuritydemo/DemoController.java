package com.learning.springsecuritydemo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Public - anyone can access it

    @GetMapping
    public String home(){
        return "Welcome to the home page! any can see this";
    }

    @GetMapping("public/info")
    public String publicInfo(){
        return "Public info endpoint - no login needed";
    }

//    user can access
@GetMapping("/user/profile")
    public String userProfile(Authentication auth){
        return "Hello "+auth.getName() +" this is User Profile"
                + " your role "+ auth.getAuthorities();
    }

    // Admin can access
    @GetMapping("/admin/dashboard")
    public String adminDashboard(Authentication auth){
        return "Hello "+auth.getName() +" this is Admin Dashboard"
                + " your role "+ auth.getAuthorities();
    }


    @GetMapping("api/secret")
    @PreAuthorize("hasRole('ADMIN')")
    public String secretInfo(Authentication auth) {
        return "Secret info endpoint - only for ADMINs. Hello " + auth.getName() + "!";


    }

}


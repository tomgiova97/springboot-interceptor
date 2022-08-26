package com.tomgiova.springinterceptor.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @PostMapping("/login")
    public String demoLogin(){
        return "User successfully logged in";
    }

    @PostMapping("/logout")
    public String demoLogout(){
        return "User successfully logged out";
    }

    @PostMapping("/token")
    public String demoTokenValidation(){
        return "Token valid";
    }
}

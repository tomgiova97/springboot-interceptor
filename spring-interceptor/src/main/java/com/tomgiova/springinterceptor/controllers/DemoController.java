package com.tomgiova.springinterceptor.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping
    public ResponseEntity<String> demoGetMethod(){
        return new ResponseEntity<String>("demoData fetched successfully", HttpStatus.OK);
    }
}

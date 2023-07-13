package com.khayal.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainPage {

    @GetMapping
    private String showPage(){

        return "Welcome to main page!";
    }
}

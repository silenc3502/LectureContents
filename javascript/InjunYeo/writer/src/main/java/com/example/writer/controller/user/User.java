package com.example.writer.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(value="/user")

public class User {

    @GetMapping("/login")
    public String getLogin(){
        log.info("getLogin()");

        return "user/login";
    }

    @PostMapping("/login")
    public String postUserLogin(){
        log.info("postUserLogin()");

        return"user/success";
    }

    @GetMapping("/register")
    public String getUserRegister(){
        log.info("getUserRegister()");

        return"user/register";
    }



}

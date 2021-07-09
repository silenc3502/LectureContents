package com.example.sails.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MainController {

    @GetMapping("/")
    public String mainPage(){
        log.info("mainPage()");

        return"mainPage";
    }


}

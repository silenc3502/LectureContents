package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class Controller0614 {
    @GetMapping("/heightWidthTest")
    public String heightWidthTest(){
        log.info("heightWidthTest");

        return "Review0614/heightWidthTest";
    }
    @GetMapping("/divTest")
    public String divTest(){
        log.info("divTest");

        return "Review0614/divTest";
    }
    @GetMapping("/aTagTest")
    public String aTagTest(){
        log.info("aTagTest");

        return "Review0614/aTagTest";
    }
    @GetMapping("/formTest")
    public String formTest(){
        log.info("formTest");

        return "Review0614/formTest";
    }
    // PostMapping
    @PostMapping("/memberRegister")
    public String memberRegister(){
        log.info("memberRegister");

        return "redirect:/";
        // redirect: -> 특정한 URL 위치로 맵핑
    }



}




















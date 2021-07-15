package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller

public class SecondController {

    @GetMapping("/heightWidthTest")
    public String heightWidthTest ()    {
        log.info("heightWidthTest()");

        return "/second/heightWidthTest";
    }

    @GetMapping("/divTest1")
    public String divTest1()    {
        log.info("divTest1()");

        return "/second/divTest1";
    }

    @GetMapping("/divTest2")
    public String divTest2()    {
        log.info("divTest2()");

        return "/second/divTest2";
    }

    @GetMapping("/aTagTest")
    public String aTagTest()    {
        log.info("aTagTest()");

        return "/second/aTagTest";
    }

    @GetMapping("/formTest1")
    public String formTest1()    {
        log.info("formTest1()");

        return "/second/formTest1";
    }

//    method 값을 post로 줘서 PostMapping이라 슨다
//    Get 아님
    @PostMapping("/memberRegister")
    public String memberRegister()    {
        log.info("memberRegister()");

        return "redirect/";
    }
}

package com.example.demo.newcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class Secondcontroller {

    @GetMapping("/heighWidthTest")
    public  String heighWidthTest (){
        log.info("heighWidthTest");
        return "/second/heighWidthTest";
    }
    @GetMapping("/divTest2")
    public String divTest1(){
        log.info("divTest()");

        return "/second/divTest2";
    }
    @GetMapping("/divTest3")
    public  String divTest3(){
        log.info("divTest3");
        return "/second/divTest3";
    }
    @GetMapping("/aTagTest")
    public  String aTagTest(){
        log.info("aTagTest");
        return "/second/aTagTest";
    }
    @GetMapping("formTest1")
    public  String formTest1(){
        log.info("formTest1");

        return "/second/formTest1";
    }

    @PostMapping("/memberRegister")
    public  String memberRegister(){
        log.info("memberRegister()");

        return "redirect:/heighWidthTest";
    }
}

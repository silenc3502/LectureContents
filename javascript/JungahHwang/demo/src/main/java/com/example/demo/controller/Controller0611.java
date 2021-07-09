package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Controller0611 {
    @GetMapping("/fail")
    public String doFail(){
        log.info("doFail()");

        return "Review0611/fail";
    }

    @GetMapping("/htmlList")
    public String doHtmlList() {
        log.info("doHtmlLIst()");

        return "Review0611/list";
    }

    @GetMapping("/image")
    public String imageTest() {
        log.info("imageTest()");

        return "Review0611/image";
    }

    @GetMapping("/cholong")
    public String dogImage() {
        log.info("dogImage()");

        return "Review0611/cholong";
    }

    @GetMapping("/font")
    public String fontTest() {
        log.info("fontTest()");

        return "Review0611/font";
    }

    @GetMapping("/firstTable")
    public String tableTest1() {
        log.info("tableTest1()");

        return "Review0611/tableTest1";
    }

    @GetMapping("/secondTable")
    public String tableTest2() {
        log.info("tableTest2()");

        return "Review0611/tableTest2";
    }

    @GetMapping("/thirdTable")
    public String tableTest3() {
        log.info("tableTest3()");

        return "Review0611/tableTest3";
    }




}
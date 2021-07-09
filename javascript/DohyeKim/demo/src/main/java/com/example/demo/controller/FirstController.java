package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FirstController {

    @GetMapping("/imageTest")
    public String imageTest () {
        log.info("imageTest()");
        return "first/image";
    }

    @GetMapping("/firstTableTest")
    public String firstTableTest () {
        log.info("firstTableTest()");

        return "first/TableTest";
    }

    @GetMapping("/secondTableTest")
    public String secondTableTest () {
        log.info("secondTableTest()");

        return "first/TableTest2";
    }

    @GetMapping("/thirdTableTest")
    public String thirdTableTest () {
        log.info("thirdTableTest()");

        return "first/tableTest3";
    }
}
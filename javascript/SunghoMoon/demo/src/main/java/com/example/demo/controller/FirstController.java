package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FirstController {

    @GetMapping("/htmlList")
    public String doHtmlList () {
        log.info("doHtmlList()");

        return "first/list";
    }

    @GetMapping("/fontTest")
    public String doImageTest () {
        log.info("dofontTest()");

        return "first/font";
    }
    @GetMapping("/markTest")
    public String doMarkTest () {
        log.info("doMarkTest()");

        return "first/mark";
    }
    @GetMapping("/firstTableTest")
    public String firstTableTest () {
        log.info("firstTableTest()");

        return "first/tableTest1";
}
    @GetMapping("/secondTableTest")
    public String secondTableTest () {
        log.info("scecondTableTest()");

        return "first/tableTest2";
    }

    @GetMapping("/homeWork0614")
    public String dohomeWork0614 () {
        log.info("dohomeWork0614()");

        return "first/homeWork0614";
    }
}
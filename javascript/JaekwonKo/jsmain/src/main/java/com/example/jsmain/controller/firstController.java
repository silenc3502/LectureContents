package com.example.jsmain.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class firstController {
    private static final Logger log = LoggerFactory.getLogger(firstController.class);

    public firstController() {
    }

    @GetMapping({"/htmlList"})
    public String doHtmlList() {
        log.info("doHtmlList()");
        return "first/list";
    }

    @GetMapping({"/imageTest"})
    public String doImageTest() {
        log.info("doImageTest()");
        return "first/image";
    }

    @GetMapping({"/fontTest"})
    public String doFontTest() {
        log.info("doFontTest");
        return "first/font";
    }

    @GetMapping({"/markTest"})
    public String doMarkTest() {
        log.info("doMarkTest");
        return "first/mark";
    }

    @GetMapping({"/firstTableTest"})
    public String firstTableTest() {
        log.info("firstTableTest()");
        return "first/tableTest1";
    }

    @GetMapping({"/secondTableTest"})
    public String secondTableTest() {
        log.info("secondTableTest()");
        return "first/tableTest2";
    }

    @GetMapping({"/thirdTableTest"})
    public String thirdTableTest() {
        log.info("thirdTableTest()");
        return "first/tableTest3";
    }

    @GetMapping({"/prob64"})
    public String prob64() {
        log.info("prob64()");
        return "first/prob64";
    }
}

package com.example.jsmain.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlTestController {
    private static final Logger log = LoggerFactory.getLogger(HtmlTestController.class);

    public HtmlTestController() {
    }

    @GetMapping({"/"})
    public String firstIndex() {
        log.info("firstIndex() 실행");
        return "htmlHi";
    }

    @GetMapping({"/fail"})
    public String doFail() {
        log.info("doFail()");
        return "fail";
    }
}
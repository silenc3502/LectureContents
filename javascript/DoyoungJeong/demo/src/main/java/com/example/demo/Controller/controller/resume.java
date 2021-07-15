package com.example.demo.controller.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class resume {

    @GetMapping("/resume")
    public String showResume() {
        log.info("showResume()");

        return "first/resume";
    }

    @GetMapping("/resume2")
    public String showResume2() {
        log.info("showResume2()");

        return "first/resume2";
    }



}

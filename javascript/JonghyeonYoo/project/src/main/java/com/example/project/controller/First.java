package com.example.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class First {

    @GetMapping("/mail")
    public String mail() {
        log.info("mail()");

        return "/signup/mail";
    }
}

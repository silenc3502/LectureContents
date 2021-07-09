package com.example.Project.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String homeIndex() {
        log.info("homeIndex()");

        return "/home/homeIndex";
    }
}

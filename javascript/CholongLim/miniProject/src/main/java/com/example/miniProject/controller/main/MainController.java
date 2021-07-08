package com.example.miniProject.controller.main;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class MainController {

    @GetMapping("/main")
    public String getMain() {
        log.info("getMain()");

        return "/main/mainHome";
    }
}
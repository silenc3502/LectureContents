package com.example.first.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeworkController {

    @GetMapping("/resume")
    public String doResume()
    {
        log.info("Resume이 실행됨.");
        return "homework/resume";
    }


}

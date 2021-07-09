package com.example.first.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ProjectController {
    @GetMapping("/project1")
    public String doProject()
    {
        log.info("doProject 실행됨.");
        return "project1/project1";
    }
}

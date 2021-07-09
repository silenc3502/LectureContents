package com.example.Quiz.controller.javascript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Quiz0628Controller {
    @GetMapping("/interest")
    public String getInterest(){
        log.info("getInterest()");

        return "javascript/interest";
    }
}

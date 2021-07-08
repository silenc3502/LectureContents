package com.example.Quiz.controller.javascript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Quiz0630Controller {
    @GetMapping("/userList")
    public String getUserList(){
        log.info("getUserList()");

        return "/javascript/userList";
    }
    @GetMapping("/domTest")
    public String getDomTest(){
        log.info("getDomTest()");

        return "/javascript/domTest";
    }
}

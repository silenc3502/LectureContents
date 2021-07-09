package com.example.project.controller.rogin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/css")
public class LoginController {

    @GetMapping("/login")
    public String getLogin() {
        log.info("getLogin()");

        return "/member/login";
    }
    @GetMapping("/memberSignUp")
    public String getSignUp() {
        log.info("getSignUp()");

        return "/member/memberSignUp";
    }
}

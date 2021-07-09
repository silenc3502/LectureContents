package com.example.market.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/css")
public class marketcsscontroller {
    @GetMapping("/homepage")
    public String gethomepage(){
        log.info("gethomepage()");

        return "/market/marketcss/csshomepage";
    }
}

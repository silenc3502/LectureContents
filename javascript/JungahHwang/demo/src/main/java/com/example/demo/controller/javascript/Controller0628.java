package com.example.demo.controller.javascript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Controller0628 {

    @GetMapping("/localeString")
    public String getLocaleString(){
        log.info("getLocaleString");

        return "javascript/Review0628/localeStringTest";
    }
    @GetMapping("/customObject")
    public String getCustomObject(){
        log.info("getCustomObject");

        return "javascript/Review0628/customObjectTest";
    }
    @GetMapping("/destDay")
    public String getDestDay(){
        log.info("getDestDay");

        return "javascript/Review0628/destDayTest";
    }
}













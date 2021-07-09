package com.example.demo.controller.javascript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Controller0630 {
    @GetMapping("listWithArray")
    public String getListWithArray(){
        log.info("getListWithArray()");

        return "/javascript/Review0630/listWithArrayTest";
    }
    @GetMapping("dom")
    public String getDom(){
        log.info("getDom()");

        return "/javascript/Review0630/domTest";
    }

}
























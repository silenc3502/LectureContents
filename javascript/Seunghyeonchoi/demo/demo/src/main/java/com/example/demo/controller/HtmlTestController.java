package com.example.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class HtmlTestController {
    // HtmlTestController가 제어하는 요소를 디버깅하도록 서포트하는 객체
    //static final Logger log = LoggerFactory.getLogger(HtmlTestController.class);


    @GetMapping("/index")
    public String firstIndex () {
        //

        log.info("firstIndex() 실행");

        return "htmlHi";
    }
    @GetMapping("/fail")
    public String failIndex () {
        //

        log.info("failIndex() 실행");

        return "fail";
    }




}

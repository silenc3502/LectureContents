package com.example.demo.controller.javascript;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TwelvethJavaScriptTestController {


    @GetMapping("checkListWithArrayTest")
    public String getCheckListWithArrayTest(){

        log.info("getCheckListWithArrayTest()");

        return "/javascript/twelveth/checkListWithArrayTest";
    }

    @GetMapping("userListWithArrayTest")
    public String getUserListWithArrayTest(){

        log.info("getUserListWithArrayTest()");

        return "/javascript/twelveth/userListWithArrayTest";
    }

    @GetMapping("domTest")
    public String getDomTest(){

        log.info("getDomTest()");

        return "/javascript/twelveth/domTest";
    }

    @GetMapping("domPractice")
    public String getDomPractice(){

        log.info("getDomPractice()");

        return "/javascript/twelveth/domPractice";
    }

}

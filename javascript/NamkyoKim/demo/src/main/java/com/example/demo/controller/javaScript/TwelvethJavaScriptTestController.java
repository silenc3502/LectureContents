package com.example.demo.controller.javaScript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TwelvethJavaScriptTestController {

    @GetMapping("checkListWithArrayTest")
    public String getChecklistWithArrayTest(){
        log.info("getChecklistWithArrayTest()");

        return "/javascript/twelveth/checkListWithArrayTest";
    }
    @GetMapping("userListWithArrayTest")
    public String getUserListWithArrayTest(){
        log.info("getUserListWithArrayTest()");

        return "/javascript/twelveth/userListWithArrayTest";
    }
    @GetMapping("/domTest")
    public String getDomTest(){
        log.info("getDomTest()");

        return "/javascript/twelveth/domTest";
    }
    @GetMapping("/domEventTest")
    public String getDomEventTest(){
        log.info("getDomEventTest()");

        return "/javascript/twelveth/domEventTest";
    }
}

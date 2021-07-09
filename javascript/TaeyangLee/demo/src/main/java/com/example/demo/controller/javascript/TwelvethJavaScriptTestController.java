package com.example.demo.controller.javascript;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TwelvethJavaScriptTestController {
    @GetMapping("checkListwithArrayTest")
    public String getCheckListwithArrayTest() {
        log.info("getCheckListwithArrayTest");

        return "/javascript/twelveth/checkListWithArrayTest";
    }

    @GetMapping("checkUserList")
    public String getCheckUserList() {
        log.info("getCheckUserList");

        return "/javascript/twelveth/checkUserList";
    }

    @GetMapping("domTest")
    public String getDomTest() {
        log.info("getDomTest");

        return "/javascript/twelveth/domTest";
    }

    @GetMapping("domEventTest")
    public String getDomEventTest() {
        log.info("getDomEventTest()");

        return "/javascript/twelveth/domEventTest";
    }

}

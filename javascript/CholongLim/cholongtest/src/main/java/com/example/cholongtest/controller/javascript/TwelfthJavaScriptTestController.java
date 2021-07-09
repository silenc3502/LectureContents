package com.example.cholongtest.controller.javascript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TwelfthJavaScriptTestController {

    @GetMapping("/checkListWithArrayTest")
    public String getCheckListWithArrayTest() {
        log.info("getCheckListWithArrayTest()");

        return "/javascript/Twelfth/checkListWithArrayTest";
    }

    @GetMapping("/75Quiz")
    public String get75Quiz() {
        log.info("get75Quiz()");

        return "/javascript/Twelfth/75Quiz";
    }

    @GetMapping("/domTest")
    public String getDomTest() {
        log.info("getDomTest()");

        return "/javascript/Twelfth/domTest";
    }

    @GetMapping("/76Quiz")
    public String get76Quiz() {
        log.info("get76Quiz()");

        return "/javascript/Twelfth/76Quiz";
    }
}
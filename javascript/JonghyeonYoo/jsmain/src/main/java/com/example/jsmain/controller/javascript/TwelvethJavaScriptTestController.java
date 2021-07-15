package com.example.jsmain.controller.javascript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TwelvethJavaScriptTestController {

    @GetMapping("/checkListWithArrayTest")
    public String getCheckLiistWithArrayTest() {
        log.info("getCheckLiistWithArrayTest()");

        return "/javascript/twelveth/checkListWithArrayTest";
    }
    @GetMapping("/querySelectorTest")
    public String getQuerySelectorTest() {
        log.info("getQuerySelectorTest()");

        return "/javascript/twelveth/querySelectorTest";
    }

    @GetMapping("/domTest")
    public String getDomTest() {
        log.info("getDomTest()");

        return "/javascript/twelveth/domTest";
    }

    @GetMapping("/domEvenTest")
    public String getDomEvenTest() {
        log.info("getDomEvenTest()");

        return "/javascript/twelveth/domEvenTest";
    }
}

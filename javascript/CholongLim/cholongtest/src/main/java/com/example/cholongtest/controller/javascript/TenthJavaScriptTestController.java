package com.example.cholongtest.controller.javascript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TenthJavaScriptTestController {

    @GetMapping("/javaScriptPromptTest")
    public String getJavaScriptPromptTest() {
        log.info("getJavaScriptPromptTest()");

        return "/javascript/tenth/prompt";
    }

    @GetMapping("/querySelectTest")
    public String getQuerySelectTest() {
        log.info("getQuerySelectTest()");

        return "/javascript/tenth/querySelect";
    }

    @GetMapping("/divideElementTest")
    public String getDivideElementTest() {
        log.info("getDivideElementTest()");

        return "/javascript/tenth/divideElement";
    }

    @GetMapping("/javaScriptTimeTest")
    public String getJavaScriptTimeTest() {
        log.info("getJavaScriptTimeTest()");

        return "/javascript/tenth/jsTime";
    }

    // url에서 비동기 연산이 가능함으로 알았음
    // 테스트 - saleProductTest
    @GetMapping("/saleProductTest")
    public String getSaleProductTest() {
        log.info("getSaleProductTest()");

        return "/javascript/tenth/saleProduct";
    }

    @GetMapping("/ifTest")
    public String getIfTest() {
        log.info("getIfTest()");

        return "/javascript/tenth/ifTest";
    }

    @GetMapping("/switchTest")
    public String getSwitchTest() {
        log.info("getSwitchTest()");

        return "/javascript/tenth/switchTest";
    }

    @GetMapping("/forTest")
    public String getForTest() {
        log.info("getForTest()");

        return "/javascript/tenth/forTest";
    }

    @GetMapping("/addNumber")
    public String getAddNumber() {
        log.info("getAddNumber()");

        return "/javascript/tenth/addNum";
    }

    @GetMapping("/mouseOverTest")
    public String getMouseOverTest() {
        log.info("getMouseOverTest()");

        return "/javascript/tenth/mouseOver";
    }

    @GetMapping("/invisibilityTest")
    public String getInvisibilityTest() {
        log.info("getInvisibilityTest()");

        return "/javascript/tenth/invisibility";
    }
}
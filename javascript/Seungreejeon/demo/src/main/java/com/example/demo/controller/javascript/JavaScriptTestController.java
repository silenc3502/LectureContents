package com.example.demo.controller.javascript;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class JavaScriptTestController {

    @GetMapping("getJavaScriptPromptTest")
    public String getJavaScriptPromptTest() {
        log.info("getJavaScriptPromptTest()");

        return "/javascript/ten/prompt";
    }

    @GetMapping("getQuerySelectTest")
    public String getQuerySelectTest() {
        log.info("getQuerySelectTest()");

        return "/javascript/ten/querySelect";
    }

    @GetMapping("getDivideElementTest")
    public String getDivideElementTest() {
        log.info("getDivideElementTest()");

        return "/javascript/ten/divideElement";
    }

    @GetMapping("getJavaScriptTimeTest")
    public String getJavaScriptTimeTest() {
        log.info("getJavaScriptTimeTest()");

        return "/javascript/ten/jsTime";
    }

    @GetMapping("getSaleProductTest")
    public String getSaleProductTest() {
        log.info("getSaleProductTest()");

        return "/javascript/ten/saleProduct";
    }

    @GetMapping("getIfTest")
    public String getIfTest() {
        log.info("getIfTest()");

        return "/javascript/ten/ifTest";
    }

    @GetMapping("getSwitchTest")
    public String getSwitchTest() {
        log.info("getSwitchTest()");

        return "/javascript/ten/switchTest";
    }

    @GetMapping("getForTest")
    public String getForTest() {
        log.info("getForTest()");

        return "/javascript/ten/forTest";
    }

    @GetMapping("getAddNumber")
    public String getAddNumber() {
        log.info("getAddNumber()");

        return "/javascript/ten/addNumber";
    }

    @GetMapping("getMouseOverTest")
    public String getMouseOverTest() {
        log.info("getMouseOverTest()");

        return "/javascript/ten/mouseOver";
    }

    @GetMapping("getInvisibilityTest")
    public String getInvisibilityTest() {
        log.info("getInvisibilityTest()");

        return "/javascript/ten/Invisibility";
    }
}

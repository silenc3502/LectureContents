package com.example.jswithspring.controller;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j
@CommonsLog

public class thirdController {

    @GetMapping("/checkboxTest")
    public String checkboxTest() {
        log.info("checkboxTest");

        return "/third/checkbox";
    }

    @GetMapping("/radioTest")
    public String radioTest() {
        log.info("radioTest");

        return "/third/radio";
    }

    @GetMapping("/formradioTest")
    public String formradioTest() {
        log.info("formradioTest");

        return "/third/formradio";
    }

    @GetMapping("/test")
    public String test() {
        log.info("test()");
        return "/third/test";
    }


    @GetMapping("/fieldsetLogintest")
    public String fieldsetLogintest() {
        log.info("fieldsetLogintest()");

        return "/third/fieLdsetlogin";
    }


    @GetMapping("numberRangeTest")
    public String numberRangeTest() {
        log.info("numberRangeTest()");
        return "/third/numberRange";
    }

    @GetMapping("buttonTest")
    public String buttonTest() {
        log.info("buttonTest()");

        return "/third/button";
    }

    @GetMapping("selectTest")
    public String selectTest() {
        log.info("selectTest()");

        return "/third/select";
    }

    @GetMapping("/optgroupTest")
    public String optgroupTest() {
        log.info("optgroupTest()");

        return "/third/optgroup";
    }
}
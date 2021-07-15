package com.example.cholongtest.controller.javascript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class EleventhJavaScriptTestController {

    @GetMapping("/localeStringTest")
    public String getLocaleStringTest() {
        log.info("getLocaleStringTest()");

        return "/javascript/eleventh/localeStringTest";
    }

    @GetMapping("/customObjectTest")
    public String getCustomObjectTest() {
        log.info("getCustomObjectTest()");

        return "/javascript/eleventh/customObjectTest";
    }

    // customObjectTest 내용추가 퀴즈
    @GetMapping("/71Quiz")
    public String get71Quiz() {
        log.info("get71Quiz()");

        return "/javascript/eleventh/71Quiz";
    }

    @GetMapping("/destDayTest")
    public String getDestDayTest() {
        log.info("getDestDayTest()");

        return "/javascript/eleventh/destDayTest";
    }

    // destDayTest 내용추가 퀴즈
    @GetMapping("/73Quiz")
    public String get73Quiz() {
        log.info("get73Quiz()");

        return "/javascript/eleventh/73Quiz";
    }
}

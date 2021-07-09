package com.example.demo.controller.javascript;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class EleventhJavaScriptTestController {

    // JS의 메서드 출력값을 웹페이지에 출력(HTML, CSS, JS)
    @GetMapping("/localeStringTest")
    public String getLocaleStringTest () {
        log.info("getLocaleStringTest()");

        return "/javascript/eleventh/localeStringTest";
    }

    // JS의 메서드 출력값을 웹페이지에 출력(+생성자, 배열, for문) (HTML, CSS, JS)
    @GetMapping("/customObjectTest")
    public String getCustomObjectTest () {
        log.info("getCustomObjectTest()");

        return "/javascript/eleventh/customObjectTest";
    }

    // 기념일 계산(HTML, CSS, JS)
    @GetMapping("/destDayTest")
    public String getDestDayTest () {
        log.info("getDestDayTest()");

        return "javascript/eleventh/destDayTest";
    }

    // 예금 이자 계산(숙제)
    @GetMapping("/bankTest")
    public String getBankTest() {
        log.info("getBankTest()");

        return "/javascript/eleventh/bankTest";
    }
}

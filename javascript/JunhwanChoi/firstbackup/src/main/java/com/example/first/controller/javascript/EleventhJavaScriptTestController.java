package com.example.first.controller.javascript;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class EleventhJavaScriptTestController {
    @GetMapping("/localeStringTest")
    public String getlocaleStringTest()
    {
        log.info("getlocaleStringTest()");

        return "/javascript/eleventh/localeStringTest";
    }
    @GetMapping("/customObjectTest")
    public String customObjectTest()
    {
        log.info("customObjectTest()");

        return "/javascript/eleventh/customObjectTest";
    }

    @GetMapping("/destDayTest")
    public String getDestDayTest()
    {
        log.info("getDestDayTest()");

        return "/javascript/eleventh/destDayTest";
    }

    @GetMapping("/calcMoenyTest")
    public String calcMoenyTest()
    {
        log.info("calcMoenyTest()");

        return "/javascript/eleventh/calcMoenyTest";
    }
}

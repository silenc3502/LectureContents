package com.example.demo.newcontroller.javascript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ElevenjavascriptTestController {

    @GetMapping("/localeStringTest")
    public  String getlocaleStringTest(){
        log.info("getlocaleString");

        return "/javascript/eleventh/localeStringTest";
    }
    @GetMapping("/customObjsectTest")
    public String getCustomObjectTest(){
        log.info("getCustomObjectTest()");

        return "/javascript/eleventh/customObjectTest";
    }
    @GetMapping("/destDayTest")
    public  String getdestDayTest(){
        log.info("getdestDayTest()");
        return "/javascript/eleventh/destDayTest";
    }
    @GetMapping("/Prob73")
    public String gerProb73(){
        log.info("getProb73()");

        return "/javascript/eleventh/prob73";
    }
}

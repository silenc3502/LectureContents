package com.example.demo.newcontroller.javascript;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TwelvethJavaScriptTestController {

    @GetMapping("/checkListWithArrayTest")
    public String getcheckLsitWithArrayTest(){
        log.info("getcheckLsitWithArrayTest()");

        return "/javascript/twelveth/checkListWithArrayTest";
    }


    @GetMapping("/prob75")
    public String getprob75(){
        log.info("getprob75");

        return "/javascript/twelveth/prob75";
    }

    @GetMapping("/domTest")
    public String getDomTest(){
        log.info("getDomTest()");

        return "/javascript/twelveth/domTest";
    }
    @GetMapping("/prob76")
    public String getprob76(){
        log.info("getprob76");

        return "/javascript/twelveth/prob76";
    }
}

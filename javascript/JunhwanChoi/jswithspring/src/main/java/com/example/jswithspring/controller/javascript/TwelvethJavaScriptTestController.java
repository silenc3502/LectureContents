package com.example.jswithspring.controller.javascript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TwelvethJavaScriptTestController {

    @GetMapping("checkListWithArrayTest")
    public String checkListWithArrayTest(){
        log.info("checkListWithArrayTest");

        return "/javascript/twelveth/checkListWithArrayTest";

    }

    @GetMapping("userListWithArrayTest")
    public String userListWithArrayTest(){
        log.info("userListWithArrayTest");

        return "/javascript/twelveth/userListWithArrayTest";

    }


    @GetMapping("domTest")
    public String domTest(){
        log.info("domTest");

        return "/javascript/twelveth/domTest";

    }

    @GetMapping("visibleTest")
    public String visibleTest(){
        log.info("visibleTest");

        return "/javascript/twelveth/visibleTest";

    }
}

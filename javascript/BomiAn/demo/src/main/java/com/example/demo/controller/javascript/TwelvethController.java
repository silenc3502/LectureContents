package com.example.demo.controller.javascript;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TwelvethController {
    @GetMapping("/checkListWithArrayTest")
    public String getCheckListWithArrayTest() {
        log.info("getCheckListWithArrayTest()");

        return "/javascript/twelveth/checkListWithArrayTest";
    }

    @GetMapping("/userListWithArray")
    public String getUserListWithArray() {
        log.info("getUserListWithArray()");

        return "/javascript/twelveth/userListWithArray";
    }

    @GetMapping("/domTest")
    public String getDomTest() {
        log.info("getDomTest()");

        return "/javascript/twelveth/domTest";
    }

    @GetMapping("/domEventTest")
    public String getDomEventTest() {
        log.info("getDomEventTest()");

        return "/javascript/twelveth/domEventTest";
    }

}

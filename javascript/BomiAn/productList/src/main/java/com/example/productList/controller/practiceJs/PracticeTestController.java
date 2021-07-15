package com.example.productList.controller.practiceJs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller()
public class PracticeTestController {
    @GetMapping("/getLoginTest")
    public String getLoginTest () {
        log.info("getLoginTest()");

        return "/practiceJs/loginTest";
    }

}

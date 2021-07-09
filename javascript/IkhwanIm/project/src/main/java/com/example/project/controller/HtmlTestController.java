package com.example.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HtmlTestController {
    // static final Logger log = LoggerFactory.getLogger(HtmlTestController.class);
    //Lombok이 없을경우 사용하는 Logger 방식


    @GetMapping("/")
    public String firstIndex () {
        log.info("firstIndex() 실행");

        return "Success";
    }
}

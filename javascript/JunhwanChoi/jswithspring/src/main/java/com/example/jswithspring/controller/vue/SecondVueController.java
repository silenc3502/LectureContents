package com.example.jswithspring.controller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class SecondVueController {

    @GetMapping("/secondTest")
    public String vueForTest(){
        log.info("secondTest(): 뷰로 for문을 맥이자!");

        return "/vue/second/secondTest";

    }

}

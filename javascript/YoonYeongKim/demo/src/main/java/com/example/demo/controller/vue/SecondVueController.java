package com.example.demo.controller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class SecondVueController {

    @GetMapping("/vueForTest")
    public String getVueForTest() {
        log.info("getVueForTest(): 뷰로 for문을 먹이자!");

        return "/vue/second";
    }

    // QUIZ. 77 Vue 문제
    @GetMapping("/prob77Test")
    public String getProb77Test() {
        log.info("getProb77Test(): QUIZ. 77번 문제");

        return "/vue/prob77";
    }
}

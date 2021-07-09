package com.example.demo.controller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class SecondVueController {

    @GetMapping("/vueForTest")
    public String getVueForTest() {
        log.info("getVueForTest(): 뷰로 for문을 맥이자!");

        return "/vue/second";
    }
    @GetMapping("/vueQuiz77")
    public String getVueQuiz77() {
        log.info("getVueQuiz77()");

        return "/vue/quiz77";
    }
}

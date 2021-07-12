package com.example.cholongtest.controller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class SecondVueController {

    @GetMapping("/vueForTest")
    public String getVueForTest () {
        log.info("VueForTest(): 뷰로 for문을 실행하자.");

        return "/vue/second";
    }

    @GetMapping("/monsterQuiz")
    public String getMonsterQuiz () {
        log.info("getMonsterQuiz()");

        return "/vue/monsterQuiz";
    }
}

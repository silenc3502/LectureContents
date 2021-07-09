package com.example.demo.controller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class ThirdVueController {

    @GetMapping("/getVueGame")
    public String getVueGame ()  {
        log.info("getVueGame(): 뷰로 for문을 먹이자");

        return "/vue/third";
    }

    @GetMapping("/getVueGame2")
    public String getVueGame2 ()  {
        log.info("getVueGame2(): 뷰로 for문을 먹이자");

        return "/vue/third2";
    }
}

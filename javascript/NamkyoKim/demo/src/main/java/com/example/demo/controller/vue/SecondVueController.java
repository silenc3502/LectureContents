package com.example.demo.controller.vue;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class SecondVueController {

    @GetMapping("/vueForTest")
    public String getVueForTest(){
        log.info("vueForTest(): 뷰로 for문을 맥이자!");

        return "/vue/second";
    }
    @GetMapping("/prob77")
    public String getProb77(){
        log.info("getProb77(): 게임중");

        return "/vue/prob77";
    }
}

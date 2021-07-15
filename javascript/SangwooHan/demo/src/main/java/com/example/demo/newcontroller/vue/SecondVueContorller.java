package com.example.demo.newcontroller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class SecondVueContorller {

    @GetMapping("/vueForTest")
    public  String getVueForTest(){
        log.info("gerVueForTest(): 뷰로 for문을 맥이자!");

        return "/vue/second";
    }

    @GetMapping("/vueProb77")
    public String getVueProb77(){
        log.info("gerVueProb77");

        return "/vue/prob77";
    }
}

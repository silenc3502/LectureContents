package com.example.demo.controller.vue;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class SecondVueController {

    @GetMapping("/vueForTest")
    public String getVueForTest () {
        log.info("getVueForTest(): Let's use v-for!");

        return "/vue/second";
    }
}

package com.example.jswithspring.controller.vue;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ThirdVueController {

    @GetMapping("/vueGame")
    public String vueGame(){
        log.info("vueGame()");

        return "/vue/third/third";

    }
}

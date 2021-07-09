package com.example.demo.controller.vue;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ThirdVueController {

    @GetMapping("/getVueGame")
    public String getVueGame(){

        log.info("getVueGame()");

        return"/vue/third/third";


    }

}

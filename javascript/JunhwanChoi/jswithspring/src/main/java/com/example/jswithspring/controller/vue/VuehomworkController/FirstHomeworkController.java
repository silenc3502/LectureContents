package com.example.jswithspring.controller.vue.VuehomworkController;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FirstHomeworkController {

    @GetMapping("/monsterBook")
    public String monsterBook(){
        log.info("monsterBook()");

        return "/vue/homework/monsterBook";

    }

}

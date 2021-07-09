package com.example.demo.controller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Controller0705 {
    @GetMapping("/vueModel")
    public String getVueModel(){
        log.info("getVueModel()");

        return "vue/Review0705/vueModel";
    }
}

package com.example.demo.controller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class FifthVueController {

    @GetMapping("/fifthVue")
    public String getFifthVue(){

        log.info("getFifthVue()");

        return "/vue/fifth";
    }
}

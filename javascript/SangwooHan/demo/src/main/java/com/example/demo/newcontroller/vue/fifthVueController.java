package com.example.demo.newcontroller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class fifthVueController {

    @GetMapping("/fifthVue")
    public String fifthVue(){
        log.info("fifthVue()");

        return "/vue/fifth";
    }

}

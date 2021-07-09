package com.example.demo.controller.vue;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j

public class SecondVueController {

    @GetMapping("/vueForTest")
    public String getVueForTest(){
        log.info("getVueForTest(): 뷰로 for문을 사용하자");


        return "/vue/second/vueForTest";
    }

}

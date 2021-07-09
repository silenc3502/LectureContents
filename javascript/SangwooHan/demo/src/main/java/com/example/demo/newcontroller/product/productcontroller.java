package com.example.demo.newcontroller.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class productcontroller {
    @GetMapping("/shopping")
    public  String shopping(){
        log.info("shopping()");

        return "f";
    }
}

package com.example.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FirstController {

    @GetMapping("/CAT")
    public String firstIndex() {
        log.info("CAT출력 실행");

        return "first/Cathtml";
    }


}

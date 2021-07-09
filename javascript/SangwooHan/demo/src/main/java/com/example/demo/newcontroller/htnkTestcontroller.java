package com.example.demo.newcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class htnkTestcontroller {
    //HtmlTEstcontroller가 제어 요소를 디버깅하도록 서포팅한다.
    @GetMapping("/")
    public  String firstIndex(){
        log.info("firstIndex() 실행");

        return  "htmlHi";
    }
    @GetMapping("/fail")
    public  String failed(){
        log.info("doFail");

        return  "fail";


    }
        @GetMapping("/sasa")
                public String sasad(){
            log.info("do44");
            return "sasa";
        }

}


package com.example.demo.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class SecondController_20210614 {
        @GetMapping("/heightWidth")
        public String heightWidth(){
            log.info("heightWidthTest()");
            return "/Second_20210614/heightWidth";
        }


        @GetMapping("/divTest1")
        public String divTest1() {
            log.info("divTest1()");
            return "/Second_20210614/divTest1";
        }


        @GetMapping("/divTest2")
        public String divTest2() {
            log.info("divTest2()");
            return "/Second_20210614/divTest2";
        }

        @GetMapping("/divTest3")
        public String divTest3() {
            log.info("divTest3()");
            return "/Second_20210614/divTest3";
        }

        @GetMapping("/aTag")
        public String aTag(){
            log.info("aTag()");
            return "/Second_20210614/aTag";
        }

        @GetMapping("/form")
            public String form(){
                log.info("form");
                return "/Second_20210614/form";
        }

        @PostMapping("/memberRegister")
            public String memberRegister(){
                log.info("memberRegister()");
                return "redirect:/htmlList";
                // redircet: 의 경우 특정한 url 위치로 맵핑을 강제할 수 있다.
        }
    }


package com.example.demo.newcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class firstcontroller {

    @GetMapping("/dada")
    public  String doHtmlList(){
        log.info("dada");

        return "first/dada";
    }

    @GetMapping("/imageTest")
    public  String image(){
        log.info("sdsd");
        return  "first/imge";
    }
    @GetMapping("/fontTest")
    public String dofontTest(){
        log.info("dofontTest");
        return "first/font";
    }

    @GetMapping("/MarkTest")
    public  String MarkTest(){
        log.info("doMark");

        return "first/mark";
    }
    @GetMapping("/TableTest")
    public  String Table(){
        log.info("TableTest");
        return "first/tableTest1";
    }
    @GetMapping("/TableTest2")
    public  String Table2(){
        log.info("TableTest2");
        return "first/tableTest2";
    }
    @GetMapping("/TableTest3")
    public String Table3(){
        log.info("TableTest3");
        return "first/tableTest3";
    }
    @GetMapping("/resume")
    public  String resume(){
        log.info("resume");
        return "first/resume";
    }
}

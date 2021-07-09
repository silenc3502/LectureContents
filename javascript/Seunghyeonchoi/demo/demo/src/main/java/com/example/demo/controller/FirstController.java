package com.example.demo.controller;


import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class FirstController {

    @GetMapping("/htmlList")
    public String doHtmlList () {
        //

        log.info("htmlListIndex() 실행");

        return "first/list";
    }

    @GetMapping("/image")
    public String imageIndex () {
        //

        log.info("imageIndex() 실행");

        return "first/image";
    }

    @GetMapping("/font")
    public String fontIndex () {
        //

        log.info("fontIndex() 실행");

        return "first/font";
    }

    @GetMapping("/tableTest1")
    public String tableIndex () {
        //

        log.info("tableIndex() 실행");

        return "first/tableTest1";
    }


    @GetMapping("/tableTest2")
    public String table2Index () {
        //

        log.info("table2Index() 실행");

        return "first/tableTest2";
    }

    @GetMapping("/tableTest3")
    public String table3Index () {
        //

        log.info("table3Index() 실행");

        return "first/tableTest3";
    }

    @GetMapping("/Quiz64")
    public String quiz64Index () {
        //

        log.info("quiz64Index() 실행");

        return "first/Quiz64";
    }

}

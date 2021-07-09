package com.example.first.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FirstController {

    @GetMapping("/htmlList")
    public String doHtmllist()
    {
        log.info(("doHtmllist()"));
        return "first/htmlList.html";
    }


    @GetMapping("/imageTest")
    public String doimageTest()
    {
        log.info(("doimageTest()"));
        return "first/image.html";
    }

    @GetMapping("/fontTest")
    public String doFontTest()
    {
        log.info(("doFontTest"));
        return "first/font.html";
    }

    @GetMapping("/markTest")
    public String doMarkTest()
    {
        log.info(("domarkTest()"));
        return "first/mark";   // .html을 안해도 되는듯?
    }

    @GetMapping("/firstTableTest")
    public String doTableTest()
    {
        log.info(("doTableTest()"));
        return "first/tableTest";
    }
    @GetMapping("/secondTableTest")
    public String doSecondTableTest()
    {        log.info(("doSecondTableTest()"));
        return "first/tableTest2";
    }

    @GetMapping("/thirdthTableTest")
    public String dothirdthTableTest()
    {
        log.info(("dothirdthTableTest()"));
        return "first/tableTest3";
    }

}

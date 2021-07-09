package com.example.demo.newcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/css")
public class EighthCssTestController {


    @GetMapping("/basicTest")
    public String getBasicCssTest() {
        log.info("getBasicCssTest()");

        return "/csstest/eighth/cssTest";
    }

    @GetMapping("/styleTest")
    public String getstyleTest() {
        log.info("getstyleTest()");

        return "/csstest/eighth/styleTest";
    }

    @GetMapping("/margintest")
    public String getMarginTest() {
        log.info("getMarginTest");

        return "/csstest/eighth/marginTest";
    }

    @GetMapping("/idselectTest")
    public String getidselectTest() {
        log.info("getIdselectTest()");

        return "/csstest/eighth/idselectTest";
    }

    @GetMapping("/allTest")
    public String getAllTest() {
        log.info("getAllTest()");

        return "/csstest/eighth/allTest";
    }

    @GetMapping("/classSelectTest")
    public String getclassSelectTest() {
        log.info("getclassSelectTest()");

        return "/csstest/eighth/classSelect";
    }

    @GetMapping("/TagclassSelectTest")
    public String getTagclassSelectTest() {
        log.info("getTagclassSelectTest()");

        return "/csstest/eighth/tahclassSelect";
    }

    @GetMapping("/boxTest")
    public  String getBoxTest(){
        log.info("getBoxTest()");

        return "/csstest/eighth/boxTest";
    }

    @GetMapping("/boxHoverTest")
    public  String getBoxHoverTest(){
        log.info("getBoxHoverTest()");

        return "/csstest/eighth/boxHoverTest";
    }
    @GetMapping("/fontTest")
    public  String getfontTest(){
        log.info("getfontTest()");

        return "/csstest/eighth/fontTest";
    }

    @GetMapping("/shadowTest")
    public  String getShadowTest(){
        log.info("getShadowTest()");

        return "/csstest/eighth/shadowTest";
    }

    @GetMapping("/movieFeelShadowTest")
    public  String getmovieFeelShadowTest(){
        log.info("getmovieFeelShadowTest");

        return "/csstest/eighth/movieFeelShadowTest";
    }
    @GetMapping("/textAlignTest")
    public String gettextAlignTest(){
        log.info("gettextAlignTest()");


        return "/csstest/eighth/textAlignTest";
    }
}

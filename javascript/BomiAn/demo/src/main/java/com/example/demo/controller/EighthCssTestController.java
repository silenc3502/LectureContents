package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/css")
public class EighthCssTestController {

    @GetMapping("/basicTest")
    public String getBasicTest () {
        log.info("getBasicTest()");

        return "csstest/eighth/cssTest";
    }

    @GetMapping("/styleTest")
    public String getStyleTest () {
        log.info("getStyleTest()");

        return "csstest/eighth/styleTest";
    }

    @GetMapping("/marginTest")
    public String getMarginTest () {
        log.info("getMarginTest()");

        return "csstest/eighth/marginTest";
    }
    @GetMapping("/idSelectTest")
    public String getIdSelectTest () {
        log.info("getIdSelectTest()");

        return "csstest/eighth/idSelectTest";
    }

    @GetMapping("/allTest")
    public String getAllTest () {
        log.info("getAllTest()");

        return "csstest/eighth/allTest";
    }
    @GetMapping("classSelectTest")
    public String getClassSelectTest () {
        log.info("getCalssSelectTest()");

        return "csstest/eighth/classSelectTest";
    }

    @GetMapping("/tagClassSelect")
    public String getTagClassSelect () {
        log.info("getTagClassSelect()");

        return "csstest/eighth/tagClassSelectTest";
    }

    @GetMapping("/boxTest")
    public String getBoxTest () {
        log.info("getBoxTest()");

        return "csstest/eighth/boxTest";
    }


    @GetMapping("/boxHoverTest")
    public String getBoxHoverTest () {
        log.info("getBoxHoverTest()");

        return "csstest/eighth/boxHoverTest";
    }

    @GetMapping("/fontTest")
    public String getFontTest () {
        log.info("getFontTest()");

        return "csstest/eighth/fontTest";
    }

    @GetMapping("/shadowTest")
    public String getShadowTest () {
        log.info("getShadowTest()");

        return "csstest/eighth/shadowTest";
    }

    @GetMapping("/moveFeelShadowTest")
    public String getMoveFeelShadowTest () {
        log.info("getMoveFeelShadowTest()");

        return "csstest/eighth/moveFeelShadowTest";
    }

    @GetMapping("/textAlignTest")
    public String getTextAlignTest () {
        log.info("getTextAlignTest()");

        return "csstest/eighth/textAlignTest";
    }
}

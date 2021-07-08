package com.example.demo.jswithspring.controller;

import com.example.demo.jswithspring.entity.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/css")
public class EighthcssController {
    @GetMapping("/marginTest")
    public String getMarginTest() {
        log.info("getMarginTest()");

        return "csstest/eighth/marginTest";
    }


    @GetMapping("/idSelectTest")
    public String getidSelectTest() {
        log.info("getidSelectTest()");

        return "csstest/eighth/idSelectTest";
    }

    @GetMapping("/allTest")
    public String getAllTest(Board board, Model model) throws Exception {
        log.info("getAllTest()");

        return "/board/eighth/styleTest";
    }

    @GetMapping("/classSelectTest")
    public String getclassSelectTest() {
        log.info("getclassSelectTest()");

        return "csstest/eighth/classSelectTest";

    }

    @GetMapping("/tagSelectTest")
    public String getTagSelectTest() {
        log.info("getTagSelectTest()");

        return "csstest/eighth/tagSelectTest";

    }

    @GetMapping("/boxTest")
    public String getboxTest() {
        log.info("gegboxTest()");

        return "csstest/eighth/boxTest";
    }

    @GetMapping("/boxHoverTest")
    public String getboxHoverTest() {
        log.info("getboxHoverTest()");

        return "csstest/eighth/boxHoverTest";
    }
    @GetMapping("/fontTest")
    public String getFontTest() {
        log.info("getFontTest()");

        return "csstest/eighth/fontTest";
    }

    @GetMapping("/shadowTest")
    public String getShadowTest() {
        log.info("getShadowTest()");

        return "csstest/eighth/shadowTest";
    }

    @GetMapping("/movieFeelShadowTest")
    public String getMovieFeelShadowTestt() {
        log.info("getMovieFeelShadowTest()");

        return "csstest/eighth/movieFeelShadowTest";
    }
    @GetMapping("/textAlignTest")
    public String getTextAlignTest() {
        log.info("getTextAlignTest()");

        return "csstest/eighth/textAlignTest";
    }
}

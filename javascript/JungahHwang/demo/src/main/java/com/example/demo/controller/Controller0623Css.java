package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
// 해당 컨트롤러를 사용할 때 무조건 URL 위치가 기본적으로 /css가 들어감
@RequestMapping(value = "/css")
public class Controller0623Css {
    // /css/basicTest로 연결
    @GetMapping("/basic")
    public String getBasicCss(){
        log.info("getBasicCss()");

        return "csstest/Review0623/cssTest";
    }

    @GetMapping("/style")
    public String getStyle() {
        log.info("getStyle()");

        return "csstest/Review0623/styleTest";
    }

    @GetMapping("/margin")
    public String getMargin() {
        log.info("getMargin()");

        return "csstest/Review0623/marginTest";
    }
    @GetMapping("/idSelect")
    public String getIdSelect(){
        log.info("getIdSelect()");

        return "csstest/Review0623/idSelectTest";
    }
    @GetMapping("/all")
    public String getAll(){
        log.info("getAll()");

        return "csstest/Review0623/allTest";
    }
    @GetMapping("/classSelect")
    public String getClassSelect(){
        log.info("getClassSelect()");

        return "csstest/Review0623/classSelectTest";
    }
    @GetMapping("/tagClassSelect")
    public String getTagClassSelect(){
        log.info("getTagClassSelect()");

        return "csstest/Review0623/tagClassSelectTest";
    }
    @GetMapping("/box")
    public String getBox(){
        log.info("getBox()");

        return "csstest/Review0623/boxTest";
    }
    @GetMapping("/boxHover")
    public String getBoxHover(){
        log.info("getBoxHover()");

        return "csstest/Review0623/boxHoverTest";
    }
    @GetMapping("/font")
    public String getFont(){
        log.info("getFont()");

        return "csstest/Review0623/fontTest";
    }
    @GetMapping("/shadow")
    public String getShadow(){
        log.info("getShadow()");

        return "csstest/Review0623/shadowTest";
    }
    @GetMapping("/movieFeelShadow")
    public String getMovieFeelShadow(){
        log.info("getMovieFeelShadow()");

        return "csstest/Review0623/movieFeelShadowTest";
    }
    @GetMapping("/textAlign")
    public String getTextAlign(){
        log.info("getTextAlign()");

        return "csstest/Review0623/textAlignTest";
    }



}


















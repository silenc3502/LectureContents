package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/css")
public class Controller0624Css {

    @GetMapping("/percent")
    public String getPercent(){
        log.info("getPercent()");

        return "csstest/Review0624/percentTest";
    }
    @GetMapping("/transparency")
    public String getTransparency(){
        log.info("getTransparency()");

        return "csstest/Review0624/transparencyTest";
    }
    @GetMapping("/backgroundClip")
    public String getBackgroundClip(){
        log.info("getBackgroundClip()");

        return "csstest/Review0624/backgroundClipTest";
    }
    @GetMapping("/gradient")
    public String getGradient(){
        log.info("getGradient()");

        return "csstest/Review0624/gradientTest";
    }
    @GetMapping("/customBox")
    public String getCustomBox(){
        log.info("getCustomBox()");

        return "csstest/Review0624/customBoxTest";
    }
    @GetMapping("/inlineBlock")
    public String getInlineBlock(){
        log.info("getInlineBlock()");

        return "csstest/Review0624/inlineBlockTest";
    }
    @GetMapping("/navigationBar")
    public String getNavigationBar(){
        log.info("getNavigationBar()");

        return "csstest/Review0624/navigationBarTest";
    }
    @GetMapping("/parentChild")
    public String getParentChild(){
        log.info("getParentChild()");

        return "csstest/Review0624/parentChildTest";
    }
    @GetMapping("/background")
    public String getBackground(){
        log.info("getBackground()");

        return "csstest/Review0624/backgroundTest";
    }
}

































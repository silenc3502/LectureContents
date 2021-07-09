package com.example.demo.controller.javascript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Controller0625 {

    @GetMapping("/javaScriptPrompt")
    public String getJavaScriptPrompt(){
        log.info("getJavaScriptPrompt");

        return "/javascript/Review0625/promptTest";
    }
    @GetMapping("/querySelect")
    public String getQuerySelect(){
        log.info("getQuerySelect");

        return "/javascript/Review0625/querySelectTest";
    }
    @GetMapping("/divideElement")
    public String getDivideElement(){
        log.info("getDivideElement");

        return "/javascript/Review0625/divideElementTest";
    }
    @GetMapping("/javaScriptTime")
    public String getJavaScriptTime(){
        log.info("getJavaScriptTime");

        return "/javascript/Review0625/javaScriptTimeTest";
    }
    @GetMapping("/saleProduct")
    public String getSaleProduct(){
        log.info("getSaleProduct");

        return "/javascript/Review0625/saleProductTest";
    }
    @GetMapping("/if")
    public String getIf(){
        log.info("getIf");

        return "/javascript/Review0625/ifTest";
    }
    @GetMapping("/switch")
    public String getSwitch(){
        log.info("getSwitch");

        return "/javascript/Review0625/switchTest";
    }
    @GetMapping("/for")
    public String getFor(){
        log.info("getFor");

        return "/javascript/Review0625/forTest";
    }
    @GetMapping("/addNumber")
    public String getAddNumber(){
        log.info("getAddNumber");

        return "/javascript/Review0625/addNumTest";
    }
    @GetMapping("/mouseOver")
    public String getMouseOver(){
        log.info("getMouseOver");

        return "/javascript/Review0625/mouseOverTest";
    }
    @GetMapping("/invisibility")
    public String getInvisibility(){
        log.info("getInvisibility");

        return "/javascript/Review0625/invisibilityTest";
    }
}



















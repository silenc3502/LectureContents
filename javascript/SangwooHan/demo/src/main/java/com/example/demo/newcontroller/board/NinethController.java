package com.example.demo.newcontroller.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/css")
public class NinethController {
    @GetMapping("PercentTest")
    public String getPercentTest(){
        log.info("gerPercentTest()");

        return "/csstest/nineth/percentTest";
    }

    @GetMapping("getTransparencyTest")
    public  String getTransparencyTest(){
        log.info("getTransparencyTest");

        return "/csstest/nineth/transparencyTest";
    }

    @GetMapping("/getBackgroundClipTest")
    public  String getBackgroundClipTest(){
        log.info("getBackgroundClipTest");

        return "/csstest/nineth/BackgroundClipTest";
    }
    @GetMapping("/getGradientTest")
    public String getGradientTest(){
        log.info("getGradientTest()");

        return "/csstest/nineth/GradientTest";
    }

    @GetMapping("/customBoxTest")
    public String getcustomBoxtTest(){
        log.info("getcustomBoxtTest()");

        return "/csstest/nineth/customBoxTest";
    }

    @GetMapping("/getInlineBlockTest")
    public  String getInlineBolockTest(){
        log.info("getInlineBlockTest()");

        return "/csstest/nineth/inlineblockTest";
    }
    @GetMapping("/getNavigationbarTest")
    public  String getNavigationbarTest(){
        log.info("getNavigationbarTest()");

        return "/csstest/nineth/getNavigationbarTest";
    }

    @GetMapping("/getparentChildTest")
    public String getparentChildTest(){
        log.info("getparentChildTest()");

        return "/csstest/nineth/parentChildTest";
    }

    @GetMapping("/getBackgroundUrlTest")
    public String getBackgroundTest(){
        log.info("getBackgroundUrlTest()");

        return "/csstest/nineth/BackgroundUrlTest";
    }

}

package com.example.demo.jswithspring.controller.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/css")
public class NinethController {

    @GetMapping("getPercerntTest")
    public String getPercerntTest() {
        log.info("getPercerntTest()");

        return "/csstest/basic/PercerntTest";
    }

    @GetMapping("getTransparencyTest")
    public String getTransparencyTest() {
        log.info("getTransparencyTest()");

        return "/csstest/basic/transparencyTest";
    }
    @GetMapping("getBackgroundClipTest")
    public String getBackgroundClipTest() {
        log.info("getBackgroundClipTest()");

        return "/csstest/basic/backgroundClipTest";
    }
    @GetMapping("getGradientTest")
    public String getGradientTest() {
        log.info("getGradientTest()");

        return "/csstest/basic/gradientTest";
    }
    @GetMapping("customBoxTest")
    public String getcustomBoxTest() {
        log.info("getcustomBoxTest()");

        return "/csstest/basic/customBoxTest";
    }

    @GetMapping("getInlineBlockTest")
    public String getInlineBlockTest() {
        log.info("getInlineBlockTest()");

        return "/csstest/basic/inlineBlockTest";
    }

    @GetMapping("getNavigationBarTest")
    public String getNavigationBarTest() {
        log.info("getNavigationBarTest()");

        return "/csstest/basic/navigationBarTest";
    }

    @GetMapping("getParentChildTest")
    public String getParentChildTest() {
        log.info("getParentChildTest()");

        return "/csstest/basic/parentChildTest";
    }
    @GetMapping("getBackgrounderTest")
    public String getBackgrounderTest() {
        log.info("getBackgrounderTest()");

        return "/csstest/basic/backgrounderTest";
    }
}

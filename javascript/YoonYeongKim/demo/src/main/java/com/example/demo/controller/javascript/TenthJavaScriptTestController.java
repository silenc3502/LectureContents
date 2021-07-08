package com.example.demo.controller.javascript;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TenthJavaScriptTestController {

    // 입력창을 띄어주는 동작 (HTML, CSS)
    @GetMapping("getJavaScriptPromptTest")
    public String getJavaScriptPromptTest() {
        log.info("getJavaScriptPromptTest()");

        return "javascript/tenth/prompt";
    }

    // 클릭하면 색상이 변하는 동작 (HTML, CSS)
    @GetMapping("/getQuerySelectTest")
    public String getQuerySelectTest() {
        log.info("getQuerySelectTest()");

        return "javascript/tenth/querySelect";
    }
    // 클릭하면 색상이 변하는 동작 (HTML, CSS, JS)
    @GetMapping("/getDivideElementTest")
    public String getDivideElementTest() {
        log.info("getDivideElementTest()");

        return "javascript/tenth/divideElement";
    }

    // 페이지 진입 시간을 보여주는 동작 (HTML, CSS, JS)
    @GetMapping("/getJavaScriptTimeTest")
    public String getJavaScriptTimeTest() {
        log.info("getJavaScriptTimeTest()");

        return "javascript/tenth/jsTime";
    }

    // 원가에 할인율이 적용된 값을 출력해주는 동작(HTML, CSS, JS)
    @GetMapping("/getSaleProductTest")
    public String getSaleProductTest() {
        log.info("getSaleProductTest()");

        return "javascript/tenth/saleProduct";
    }

    // 페이지에 입력창을 띄움 -> 숫자를 입력하면
    // -> JS에 입력한 if문 출력값을 페이지에 출력하는 동작(HTML, CSS, JS)
    @GetMapping("/getIfTest")
    public String getIfTest() {
        log.info("getIfTest()");

        return "/javascript/tenth/ifTest";
    }

    // 페이지에 입력창을 띄움 -> 세션을 입력하면
    // -> JS에 입력한 switch문 출력값을 페이지에 출력하는 동작(HTML, CSS, JS)
    @GetMapping("/getSwitchTest")
    public String getSwitchTest() {
        log.info("getSwitchTest()");

        return "/javascript/tenth/switchTest";
    }

    // JS에 입력한 for문 출력값을 페이지에 출력하는 동작(HTML, CSS, JS)
    @GetMapping("/getForTest")
    public String getForTest() {
        log.info("getForTest()");

        return "/javascript/tenth/forTest";
    }

    // 버튼박스를 클릭 -> 두 번의 입력창을 띄우고
    // -> 각 입력값을 더한 값을 페이지에 출력하는 동작(HTML, CSS, JS)
    @GetMapping("/getAddNumber")
    public String getAddNumber() {
        log.info("getAddNumber()");

        return "/javascript/tenth/addNum";
    }

    // 버튼박스에 마우스를 올렸을 때 메세지창을 띄우는 동작(HTML, CSS, JS)
    @GetMapping("/getMouseOverTest")
    public String getMouseOverTest() {
        log.info("getMouseOverTest()");

        return "/javascript/tenth/mouseOver";
    }

    // 버튼박스를 클릭해서 본문을 보여주고 숨겨주는 동작(HTML, CSS, JS)
    @GetMapping("/getInvisibilityTest")
    public String getInvisibilityTest() {
        log.info("getInvisibilityTest()");

        return "/javascript/tenth/invisibility";
    }
}

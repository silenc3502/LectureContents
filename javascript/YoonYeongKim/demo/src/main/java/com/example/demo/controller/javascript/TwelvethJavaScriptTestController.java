package com.example.demo.controller.javascript;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TwelvethJavaScriptTestController {

    // 체크 리스트(추가, 삭제) 만들기
    @GetMapping("checkListWithArrayTest")
    public String getCheckListWithArrayTest() {
        log.info("getCheckListWithArrayTest()");

        return "javascript/twelveth/checkListWithArrayTest";
    }

    // QUIZ. 75 querySelector 응용 문제(사용자 정보 등록)
    @GetMapping("userListWithArrayTest")
    public String getUserListWithArrayTest () {
        log.info("getUserListWithArrayTest()");

        return "/javascript/twelveth/userListWithArrayTest";
    }

    // visibility, hidden 사용
    @GetMapping("/domTest")
    public String getDomTest() {
        log.info("getDomTest()");

        return "javascript/twelveth/domTest";
    }

    @GetMapping("/domEventTest")
    public String getDomEventTest() {
        log.info("getDomEventTest()");

        return "javascript/twelveth/domEventTest";
    }
}

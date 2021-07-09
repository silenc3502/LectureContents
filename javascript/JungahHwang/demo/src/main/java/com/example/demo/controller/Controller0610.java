package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Controller0610 {
    // HtmlTestController가 제어하는 요소를 디버깅하도록 서포트하는 객체
    // static final Logger log = LoggerFactory.getLogger(HtmlTestController.class);

    // Controller가 사용자의 'ip:port/' 형식의 요청을 하였을 떄 동작할 내용 정의
    @GetMapping("/")
    // 실제 웹상에서 URL 요청할 때는 자주 사용하는 두 가지 방식 Get, Post 방식이 있음
    // 현재 우리의 ip:port 주소의 Home을 의미
    // 메인 페이지를 Mapping함
    public String firstIndex () {
        // 위에 Logger 사용하는 방식은 Lombok이 없을 경우 사용함
        // 그래서 이클립스에서는 상당히 불편하게 구성해야하는데 비해
        // 여기서는 맨 위쪽의 @Slf4j 를 추가함으로써
        // 위의 Logger 파트를 적어줄 필요가 없어짐
        log.info("firstIndex() 실행");
        // spring에서는 sout 대신 log.info를 이용해 출력

        return "Review0610/htmlHi";
        // 여기서 리턴되는 String 값은 templates/htmlHi.html을 의미
        // 이 부분에 무엇을 배치하냐에 따라 출력되는 내용이 제각각 달라짐
    }





}























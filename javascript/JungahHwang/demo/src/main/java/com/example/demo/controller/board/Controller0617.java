package com.example.demo.controller.board;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class Controller0617 {
    // @Autowired: 스프링이 자동으로 객체를 찾을 수 있게 서포트 함
    @Autowired
    private BoardService service;

    // thymeleaf에서는 아래와 같이 특정한 객체를 입력으로 받으면
    // HTML에서 th:object와 같은 키워드를 통해 정보를 얻을 수 있음
    // 즉 board 객체의 정보를 획득할 수 있음을 의미
    @GetMapping("/register")
    public String getRegister (Board board, Model model) throws Exception{
        // register.html에 th:object="${board}"에 board객체 전달
        log.info("getRegister()");

        return "board/Review0617/register";
    }

    // MVC(Model View Controller) Pattern
    // Madel: 다루는 데이터
    // view: 눈에 보이는 화면
    // Controller: URL 제어
    @PostMapping("/register")
    public String registerForm (Board board, Model model) throws Exception {
        log.info("postRegister()");

        service.register(board);

        // msg라는 속성값에 "등록이 완료되었습니다!" 를 맵핑
        // key: msg, value: "등록이 완료되었습니다!"
        model.addAttribute("msg", "등록이 완료되었습니다!");
        
        return "board/Review0617/success";
    }
}

















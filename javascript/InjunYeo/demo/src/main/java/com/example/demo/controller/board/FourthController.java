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
public class FourthController {

    //스프링이 자동으로 객체를 찾을 수 있게 서포트 함;
    @Autowired
    private BoardService service;


    //thymeleaf 에서는 아래와 같이 특정한객체를 입력으로 받으면
    //HTML에서 th:object와 같은 키워드를 통해 정보를 획들할수 있다
    //즉 board객체의 정보를 획득할수 있음을 의미한다.
    @GetMapping("/register")
    public String getRegister(Board board){
        log.info("getRegister()");


        return "/board/fourth/register";
    }

    // MVC(Model View Controller) Pattern
    // Model: 다루는 데이터
    // View: 눈에 보이는 화면.in
    // Controller: URL 제어

    @PostMapping("/register")
    //entity에 있는 Board클래스?
    public String postRegister (Board board, Model model) throws Exception {
        log.info("postRegister()");
        log.info("Board:"+board);
        log.info("Model"+model);

        service.register(board);

        //msg 에 attributeValue를 집어넣은것.
        model.addAttribute("msg","등록이 완료 되었습니다!");

        return "/board/fourth/success";
    }

}

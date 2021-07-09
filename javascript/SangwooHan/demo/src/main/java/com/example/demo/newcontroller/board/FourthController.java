package com.example.demo.newcontroller.board;

import com.example.demo.entity.Board;

import com.example.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller

public class FourthController {

    // 스프링이 자동으로 객체를 찾을 수 있게 서포트함
    @Autowired
    private BoardService service;

    @GetMapping("/register")
    public String getRegister (Board board, Model model) {
        log.info("getRegister()");

        return "/board/fourth/register";
    }
    //MVC (Model view Controller) Pattern
    // Model:  다루는데이터
    // view : 눈에 보이는 화면
    // COntroller: URL 제어
    @PostMapping("/register")
    public String postRegister ( Board board, Model model, HttpServletRequest rq) throws Exception{

        log.info("postRegister()");

        log.info("Board:" +board);

        String NAME = rq.getParameter("title");
        String NAME2 = rq.getParameter("writer");
        String NAME3 = rq.getParameter("content");




        service.register(board);

        // msg 라는 속성값에 "등록이 완료되었습니다"를 맵핌함
        // key msg value "등록이 완료되었습니다"

        model.addAttribute("msg", NAME);
        model.addAttribute("msg1", NAME2);
        model.addAttribute("msg2", NAME3);

        System.out.println(NAME);
        return "/board/fourth/success";
    }


}
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
public class Controller0623 {

    @Autowired
    private BoardService service;

    @GetMapping("/modify")
    public String getModify (int boardNo, Model model) throws Exception {
        log.info("getModify()");

        // 수정을 눌렀을 때 기존 정보를 가져와야 함
        model.addAttribute(service.read(boardNo));

        return "board/Review0623/modify";
    }
    @PostMapping("/modify")
    public String postModify (Board board, Model model) throws Exception{
        log.info("postModify");

        service.modify(board);

        model.addAttribute("msg", "수정이 완료되었습니다.");

        return "board/Review0617/success";
    }
}


























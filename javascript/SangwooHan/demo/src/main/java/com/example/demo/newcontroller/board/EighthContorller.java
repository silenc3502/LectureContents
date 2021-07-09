package com.example.demo.newcontroller.board;

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
public class EighthContorller {


    @Autowired
    private BoardService service;

    @GetMapping("/modify")
    public  String getModify (int boardNo, Model model) throws  Exception{

        log.info("getModify()");
        model.addAttribute(service.read(boardNo));
        return "/board/eighth/modify";
    }

    @PostMapping("/modify")
    public  String postModify(Board board, Model model) throws  Exception{
        log.info("postModify()");

        model.addAttribute("msg","수정되었습니다.");
        service.modify(board);
        return "/board/fourth/success";
    }
}

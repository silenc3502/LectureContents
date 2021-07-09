package com.example.personalProject2.controller;


import com.example.personalProject2.entity.BoardFree;
import com.example.personalProject2.service.BoardServiceFree;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ControllerFreeBoard {

    //Notice Board
    @Autowired
    private BoardServiceFree serviceFree;
    @GetMapping("/registerFree")

    public String getRegisterFree (BoardFree board, Model model)    {
        log.info("getRegisterFree()");

        return "/board/register/registerFree";
    }
    @PostMapping("/registerFree")
    public String postRegisterFree (BoardFree board, Model model) throws Exception  {
        log.info("postRegisterFree()");
        log.info("BoardFree: " + board);

        serviceFree.registerFree(board);

        model.addAttribute("msg", "게시물 등록이 완료되었습니다");

        return "/board/success/success";
    }
    @GetMapping("/listsFree")
    public String getListsFree (Model model) throws Exception   {
        log.info("getListsFree()");

        model.addAttribute("listsFree", serviceFree.listFree());

        return "/board/lists/listsFree";
    }

    //아래 int boardNoFree는 엔티티
    @GetMapping("/readFree")
    public String getRead (int boardNoFree, Model model) throws Exception {
        log.info("readFree()");

        model.addAttribute(serviceFree.read(boardNoFree));

        return "board/read/readFree";
    }

    // 글을 지워도 boardNo가 올라가야만 하는 이유가 무엇인가?
    // 배열 100개에서 중간의 값을 지우는 경우
    //
    @PostMapping("/removeFree")
    public String remove (int boardNoFree, Model model) throws Exception {
        log.info("removeFree()");

        serviceFree.remove(boardNoFree);

        model.addAttribute("msg", "삭제가 완료되었습니다!");

        return "board/success/success";
    }

}

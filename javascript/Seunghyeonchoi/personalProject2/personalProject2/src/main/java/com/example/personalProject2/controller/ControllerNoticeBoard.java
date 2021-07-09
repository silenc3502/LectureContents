package com.example.personalProject2.controller;


import com.example.personalProject2.entity.BoardNotice;
import com.example.personalProject2.service.BoardServiceNotice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ControllerNoticeBoard {

    //Notice Board
    @Autowired
    private BoardServiceNotice serviceNotice;
    @GetMapping("/registerNotice")
    public String getRegisterNotice (BoardNotice board, Model model)    {
        log.info("getRegisterNotice()");

        return "/board/register/registerNotice";
    }
    @PostMapping("/registerNotice")
    public String postRegisterNotice (BoardNotice board, Model model) throws Exception  {
        log.info("postRegisterNotice()");
        log.info("BoardNotice: " + board);

        serviceNotice.registerNotice(board);

        model.addAttribute("msg", "공지 등록이 완료되었습니다");

        return "/board/success/success";
    }
    @GetMapping("/listsNotice")
    public String getListsNotice (Model model) throws Exception   {
        log.info("getListsNotice()");

        model.addAttribute("listsNotice", serviceNotice.listNotice());

        return "/board/lists/listsNotice";
    }

    //아래 int boardNoFree는 엔티티
    @GetMapping("/readNotice")
    public String getRead (int boardNoNotice, Model model) throws Exception {
        log.info("readNotice");

        model.addAttribute(serviceNotice.read(boardNoNotice));

        return "board/read/readNotice";
    }

    // 글을 지워도 boardNo가 올라가야만 하는 이유가 무엇인가?
    // 배열 100개에서 중간의 값을 지우는 경우
    //
    @PostMapping("/removeNotice")
    public String remove (int boardNoNotice, Model model) throws Exception {
        log.info("removeNotice()");

        serviceNotice.remove(boardNoNotice);

        model.addAttribute("msg", "삭제가 완료되었습니다!");

        return "board/success/success";
    }

}

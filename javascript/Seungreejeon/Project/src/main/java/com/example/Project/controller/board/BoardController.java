package com.example.Project.controller.board;


import com.example.Project.entity.Board;
import com.example.Project.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class BoardController {

    @Autowired
    private BoardService boardservice;

    @GetMapping("/b_register")
    public String GetB_Register(Board board, Model model) throws Exception {
        log.info("getB_register()");

        return "/board/b_register";
    }

    @PostMapping("/b_register")
    public String postB_Register(Board board, Model model) throws Exception {
        log.info("postB_Register()");
        log.info("Board: " + board);

        boardservice.B_register(board);

        model.addAttribute("msg", "등록이 완료되었습니다.");

        return "/board/b_success";
    }

    @GetMapping("/b_lists")
    public String getB_list(Model model) throws Exception {
        log.info("getB_List()");

        model.addAttribute("lists",boardservice.list());

        return "/board/b_lists";
    }

    @GetMapping("/b_read")
    public String getB_read(Model model,int boardNo) throws Exception {
        log.info("getB_read()"+ boardNo);

        model.addAttribute(boardservice.read(boardNo));

        return "/board/b_read";
    }
}

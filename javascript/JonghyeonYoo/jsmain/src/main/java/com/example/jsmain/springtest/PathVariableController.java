package com.example.jsmain.springtest;

import com.example.jsmain.entity.Board;
import com.example.jsmain.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/board")
public class PathVariableController {

    @Autowired
    private BoardService service;

    @GetMapping("/modify")
    public String getBoardModify (int boardNo, Model model) throws Exception{
        log.info("getBoardModify()");

        //수정을 눌렀을때 기존 정보를 가져와야함
        model.addAttribute(service.read(boardNo));

        return "/board/eighth/modify";
    }

    @PostMapping("/modify")
    public String postBoardModify (Board board, Model model) throws Exception {
        log.info("postBoardModify()" + board);

        service.modify(board);

        model.addAttribute("msg", "수정이 성공적으로 완료되었습니다.");

        return "/board/fourth/success";
    }
    @GetMapping("/lists")
    public String getBoardLists (Model model) throws Exception {
        log.info("getBoardLists()");

        model.addAttribute("lists", service.list());

        return "/board/fifth/lists";
    }
    @GetMapping("/register")
    public String getBoardRegister (Board board, Model model) {
        log.info("getBoardRegister()");

        return "/board/fourth/register";
    }

    @PostMapping("/register")
    public String postBoardRegister (Board board, Model model) throws Exception {
        log.info("postBoardRegister()");
        log.info("Board: " + board);

        service.register(board);

        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "/board/fourth/success";
    }
    @GetMapping("/read/{boardNo}")
    public String getBoardRead (@PathVariable("boardNo") int boardNo, Model model) throws Exception {
        log.info("getBoardRead():" + boardNo);

        model.addAttribute(service.read(boardNo));

        return "board/seventh/read";
    }

    @PostMapping("/remove")
    public String getBoardRemove (int boardNo, Model model) throws Exception {
        log.info("getBoardRemove()");

        service.remove(boardNo);

        model.addAttribute("msg", "삭제가 완료되었습니다!");

        return "board/fourth/success";
    }
}

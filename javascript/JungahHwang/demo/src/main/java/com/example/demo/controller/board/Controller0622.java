package com.example.demo.controller.board;

import com.example.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class Controller0622 {

    @Autowired
    private BoardService service;

    @GetMapping("/read")
    public String getRead (int boardNo, Model model) throws Exception {
        log.info("read");

        // read는 Board 객체를 리턴함
        model.addAttribute(service.read(boardNo));

        return "board/Review0622/read";
    }
    // 게시물을 지워도 board_no가 다시 1번부터 정렬되지 않는 이유
    // 배열에서 중간 값을 지운상황과 같음
    @PostMapping("/remove")
    public String remove (int boardNo, Model model) throws Exception{
        log.info("remove()");

        service.remove(boardNo);

        model.addAttribute("msg", "삭제가 완료되었습니다.");

        return "board/Review0617/success";
    }
}




























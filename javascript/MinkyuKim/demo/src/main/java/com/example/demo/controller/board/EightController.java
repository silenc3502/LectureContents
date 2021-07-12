// 수정
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
public class EightController {

    @Autowired
    private BoardService service;


    @GetMapping("/modify")
    public String getModify (int boardNo, Model model) throws Exception {
        log.info("getModify()") ;


        //수정을 눌렀을 때 기존 정보를 가져와야함.
        model.addAttribute(service.read(boardNo));

        return "board/eighth/modify";
    }


    @PostMapping("/modify")
    //++ entity의 Board
    public String modify (Board board, Model model) throws Exception {
        //log.info("postModify()");
        log.info("postModify()" + board);
        // --> 값 확인하기 위해서(디버깅)

        //++가져온 보드정보를 실제 db에 적용
        service.modify(board);
        model.addAttribute("msg", "수정이 완료되었습니다!");

        return  "/board/fourth/success";
    }
}

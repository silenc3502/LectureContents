package com.example.jswithspring.controller.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class SeventhController {
    @Autowired



    @GetMapping("/read")
    public String getResd (int boardNo, Model model) throws Exception {
        log.info("read");

        return "board/seventh/read";
    }

    @PostMapping("/remove")
    public String remove (int boardNo, Model model) throws Exception {
        log.info("remove");

        service.remove(boardNo);

        model.addAttribute("msg", "삭제가 완료 되었습니다");

        return "bpard/fourth/success";
    }

}

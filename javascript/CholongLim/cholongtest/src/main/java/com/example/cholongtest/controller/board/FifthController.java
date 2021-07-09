package com.example.cholongtest.controller.board;


// 원래는 FourContoller랑 하나지만,
// 강의분류를 위해 나눠쓴다.
// 프로젝트에서는 기존 컨트롤러 아래로 들어갈 것


import com.example.cholongtest.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FifthController {

    @Autowired
    private BoardService service;

    @GetMapping("/lists")
    public String getLists (Model model) throws Exception {
        log.info("getLists()");

        model.addAttribute("lists",service.list());

        return "/board/fifth/lists";
    }
}

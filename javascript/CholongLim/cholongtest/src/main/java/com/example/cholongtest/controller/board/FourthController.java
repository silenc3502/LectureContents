package com.example.cholongtest.controller.board;

import com.example.cholongtest.entity.Board;
import com.example.cholongtest.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class FourthController {

    // 스프링이 자동으로 객체를 찾을 수 있게 서포트함
    @Autowired
    private BoardService service;

    // thymeleaf에서는 아래와 같이 특정한 객체를 입력으로 받으면
    // HTML에서 th:object를 통해
    @GetMapping("/register")
    // get = public 비슷한 개념
    public String getRegister (Board board, Model model) {
        log.info("getRegister()");

        return "/board/fourth/register";
    }

    // 웹 에서 처리하는 데이터는 PostMapping을 사용함
    // url노출이 없기때문에 보안 차,
    // MVC(Model View Controller) Pattern
    // Model : 다루는 데이터
    // View : 눈에 보이는 화면
    // Controller : URL 제어

    // post = private
    @PostMapping("/register")
    public String postRegister (Board board, Model model) throws Exception {
        log.info("postRegister()");
        log.info("Board: " + board);

        service.register(board);

        // msg 라는 속성값에 "등록이 완료되었습니다!"을 맵핑함
        // key: msg, value: "등록이 완료되었습니다!" 라고 생각하면 편함
        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "/board/fourth/success";
    }
}

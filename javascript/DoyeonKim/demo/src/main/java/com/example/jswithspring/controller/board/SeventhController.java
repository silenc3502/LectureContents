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
    private com.example.demo.jswithspring.service.BoardService service;


    @GetMapping("/read")
    public String getRead (int boardNo, Model model) throws Exception {
        log.info("read");

        // read가 리턴하는 결과는 무엇인가 ? Board 객체(Board 클래스의 메모리 적재 상태)
        // 클래스는 앞대가리 및 이니셜이 대문자
        // 클래스가 아닌 일반 변수들(객체 포함)
        // 앞대가리가 소문자고 이니셜은 대문자임 <<<<----
        // SignUp ---> signUp O    (SignUp x) <<<--- 인식 못함
        model.addAttribute(service.read(boardNo));

        return "board/seventh/read";
    }

    @PostMapping("/remove")
    public String remove (int boardNo, Model model) throws Exception {
        log.info("remove");

        service.remove(boardNo);

        model.addAttribute("msg", "삭제가 완료 되었습니다");

        return "board/fourth/success";
    }

}

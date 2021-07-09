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
public class SeventhController {

    @Autowired
    private BoardService service;


    @GetMapping("/read")
    //++ boarNo는 게시글 번호를 의미. mysql에서 해당 보드넘버에 해당되는 정보만을 출력해낼 수 있음
    public String getRead (int boardNo, Model model) throws Exception {
        log.info("read");

        //++ read의 역할은 데이터(게시글번호)를 읽는 역할을 한다.
        //++ 서비스쪽에 보드넘버값을 전달한다.
        // read가 리턴하는 결과값은 무엇인가? Board 객체(Board 클래스의 메모리 적재 상태)
        // 클래스는 앞대가리 및 이니셜이 대문자 <<<--- 명명규칙
        // 클래스가 아닌 일반 변수들(객체 포함)
        // 앞대가리가 소문자고 이니셜은 대문자입 <<<--- 명명규칙
        // SignUp ---> signUp 싸임리프에서 인식을 못함(자바의 명명규칙에 위배되었기 때문에)
        // read.html 의 th:object="${board}"
        model.addAttribute(service.read(boardNo));

        return "board/seventh/read";
    }

    // 글을 지워도 숫자가 올라가야만 하는 이유가 무엇인가?
    // 배열 100개에서 중간의 값을 지우는 경우
    @PostMapping("/remove")
    public String remove (int boardNo, Model model) throws Exception {
        log.info("remove");

        service.remove(boardNo);

        model.addAttribute("msg", "삭제가 완료되었습니다!");

        return "board/fourth/success";

    }
}
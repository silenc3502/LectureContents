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
    public String getRead(int boardNo, Model model) throws Exception{
        log.info("read");
        log.info("boardNo "+ boardNo);
        //read가 리턴하는 결과는 무엇인가? Board 객체 (Board 클래스의 메모리 적재상태)
        //클래스는 앞이 대문자
        //일반 변수들은 소문자로 시작
        //싸임리프는 앞이 대문자면 인식을 못하기때문에 service.read로 넘어오는 객체를 인식하게 하기위해 service.read를 사용한다.
        model.addAttribute(service.read(boardNo));

        return "board/seventh/read";

    }

    //글을 지워도 숫자가 올라가야만 하는 이유가 무엇인가?
    //배열 100개에서 중간값을 지우는 경우(중간값이 빌뿐 배열이 당겨지지 않는다).
    @PostMapping("/remove")
    public String remove(int boardNo, Model model) throws Exception{
        log.info("remove");

        service.remove(boardNo);
        model.addAttribute("msg","삭제가 완료되었습니다!");

        return "board/fourth/success";


    }


}

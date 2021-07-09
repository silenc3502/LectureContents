package com.example.demo.controller.board;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardServiceImpl;
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
    private BoardServiceImpl service;

    @GetMapping("/read")
    public String getRead (int boardNo, Model model) throws Exception {
        //위에서 처음에 받게되는 boardNo은 어디서 시작되는지 궁금합니다.
        log.info("read");

        model.addAttribute(service.read(boardNo));
        //key값과 value가 없는데 그냥 service의 read메소드에 boardNo를 단순히 전달하는 역할인가요?
        //그렇다면 그냥 service.read(boardNo) 이렇게 써도 되는것 아닌지?

        return "/board/fourth/read";
    }

    @PostMapping ("/delete")
    public String delete(int boardNo, Model model) throws Exception {
        log.info("getDelete");

        service.delete(boardNo);

        model.addAttribute("msg", "삭제가 완료되었습니다.");

        return "/board/fourth/success";
    }

    @GetMapping ("/modify")
    public String getModify(int boardNo, Model model) throws Exception {
        log.info("getModify()");

        model.addAttribute(service.read(boardNo));
        //저장된 데이터를 불러올 때는 model.attr
        //read에 불러와야할, 비어있는 board객체가 key이고, service.read(boardNo)해서 db값이 들어간 board객체(results)를
        //value로 부여해 read페이지에 value값을 세팅한다.. 라고 보면될까요?

        return "/board/fourth/modify";
    }

    @PostMapping ("/modify")
    public String postModify(Board board, Model model) throws Exception {
        log.info("postModify(): " + board);

        service.modify(board);
        //데이터를 db에 적용할 때는 model.attr쓰지 않음.

        model.addAttribute("msg","수정 완료!");

        return "/board/fourth/success";
    }

}

package com.example.demo.controller.board;
import com.example.demo.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 원래 같은 컨트롤러끼리는 묶어놔야함.
@Slf4j
@Controller
public class FifthController {

    @Autowired
    private BoardService service;

    @GetMapping("/lists")
    public String getLists (Model model) throws Exception {
        log.info("getLists()");

        //++ 여기서 service.list를 구동시키기 위해선?
        //++ 등록된 글들을 뿌려준다. 보드서비스에 리스트가 구현되어있어야만 작동하고 없다면 오류난다. 일시적 주석처리 후 다시 리스트 생성
        //++ 보드리포지토리를 작성했으면 주석을 열어준다.
        //++ 이게 게시물을 전달해주는것? 게시물 목록보기에?

        model.addAttribute("lists", service.list());

        return "/board/fifth/lists";
    }
}

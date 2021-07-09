package com.example.demo.Controller.board;

import com.example.demo.Controller.service.BoardService;
import com.example.demo.entity.Board;
import com.example.demo.entity.SignUp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class FourthController {

    @Autowired
    private BoardService service;

    @GetMapping("/register")
    public String getRegister (Board board, Model model) {
        log.info("getRegister()");

        return "/board/fourth/register";
    }

    @PostMapping("/register")
    public String postRegister (Board board, Model model) throws Exception{
        log.info("postRegister()");

        log.info("Board: " + board);

        service.register(board);

        model.addAttribute("msg", "등록 완료!");

        return "/board/fourth/success";
    }

    @GetMapping("/joinMembership")
    public String getJoinMembership (SignUp signup, Model model) {
        log.info("getJoinMembership()");

        return "/signup/joinMemberShip";
    }

    @PostMapping("/joinMembership")
    public String postSignUp (SignUp signup, Model model) throws Exception{
        log.info("postJoinMembership()");
        log.info("Signup: " + signup);

        model.addAttribute("signup", "가입완료");

        return "/signup/signupSuccess";
    }
    //dddd

}

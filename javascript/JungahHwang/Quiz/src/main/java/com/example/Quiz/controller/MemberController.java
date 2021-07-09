package com.example.Quiz.controller;

import com.example.Quiz.entity.Member;
import com.example.Quiz.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberService service;

    @GetMapping("/signup")
    public String getSignUp (Member member, Model model){
        log.info("getSignUp()");

        return "/member/signup";
    }
    @PostMapping("/signup")
    public String postSignUp (Member member, Model model) throws Exception{
        log.info("postSignUp()");

        String pw = member.getPw();
        if(pw.length() < 8 ){
            return "redirect:/signup";
        }

        service.signup(member);
        model.addAttribute("msg", "가입이 완료되었습니다.");

        return "/member/success";
    }
    @GetMapping("/login")
    public String getLogin (Member member, Model model){
        log.info("getLogin");

        return "member/login";
    }
    @PostMapping("/login")
    public String postLogin (Member member, Model model) throws Exception{
        log.info("postLogin");

        service.login(member);
        model.addAttribute("msg", "로그인이 완료되었습니다.");

        return "/member/success";
    }
    @GetMapping("/memberLists")
    public String getMemberLists (Member member, Model model) throws Exception {
        log.info("getMemberLists");

        model.addAttribute("memberLists", service.memberList());

        return "member/memberLists";
    }
}

package com.example.Practice.controller;

import com.example.Practice.domain.Member;
import com.example.Practice.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class memberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String getIndex(Model model) {
        log.info("getIndex()");

        model.addAttribute("data", "홈피임");

        return "/index";
    }

    @GetMapping("/signUp")
    public String getSignUp(Member member, Model model) {
        log.info("getSignUp()");

        return "enroll";
    }
    @PostMapping("/signUp")
    public String postSignUp(Member member, Model model) {

        log.info("getSignUp");

        model.addAttribute("data", "등록되었습니다.");
//        memberService.enroll(member);

        return "success";
    }
}

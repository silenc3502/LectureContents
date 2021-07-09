package com.example.demo.controller.member;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("/register")
    public String getMemberRegister (Member member, Model model) {
        log.info("getMemberRegister()");

        return "/member/register";
    }

    @PostMapping("/register")
    public String postMemberRegister (Member member, Model model) throws Exception {
        log.info("postMemberRegister()");
        log.info("Member: " + member);

        service.register(member);

        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "/member/success";
    }
}
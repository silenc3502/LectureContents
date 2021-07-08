package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
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

    @GetMapping("/memberSignup")
    public String getMemberSignup(Member member, Model model) {
        log.info("getMemberSignup()");

        return "/member/memberSignup";
    }

    @PostMapping("/memberSignup")
    public String postSignupSuccess(Member member, Model model) throws Exception {
        log.info("postMemberSignup()");

//        String pw = member.getPw();
//        if(pw.length() <= 8) {
//            return "/redirect:/member/memberSignup";
//        } else {
          // 8자리보다 짧게 입력하면 에러.

            service.memberSignup(member);
            model.addAttribute("msg", "가입되셨습니다!");
            return "/member/signupSuccess";
//       }
    }

    @GetMapping("/memberLogin")
    public String getMemberLogin(Member member, Model model) {
        log.info("getMemberLogin()");

        return "/member/memberLogin";
    }

    @PostMapping("/memberLogin")
    public String postMemberLogin(Member member, Model model) throws Exception {
        log.info("postMemberLogin()");


        if (service.loginCheck(member) == true) {
            model.addAttribute("msg", "로그인되셨습니다!");
        } else {
            model.addAttribute("msg", "로그인 실패!");
        }

        return "/member/signupSuccess";
    }

    @GetMapping("/memberList")
    public String getMemberList(Member member, Model model) throws Exception {
        log.info("getMemberList()");

        model.addAttribute("memberList", service.list());
        return "/member/memberList";
    }
}

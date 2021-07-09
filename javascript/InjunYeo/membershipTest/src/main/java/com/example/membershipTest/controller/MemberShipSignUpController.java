package com.example.membershipTest.controller;

import com.example.membershipTest.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MemberShipSignUpController {

    //private Signservice service;

    @GetMapping("signup")
    public String getSignup(Member member, Model model){
        log.info("getSignup()");

        return "member/signUp";
    }

    @PostMapping("signup")
    public String postSignUp(Member member, Model model){
        log.info("postSignUp()");


        model.addAttribute("msg","등록이 완료 되었습니다!");

        return "member/success";
    }


}

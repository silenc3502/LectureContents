package com.example.FirstProject.controller;

import com.example.FirstProject.entity.Join;
import com.example.FirstProject.service.JoinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class JoinController {
    @Autowired
    private JoinService service;

    @GetMapping("/join")
    public String getJoin (Join join, Model model) throws Exception{
        log.info("getJoin()");

        return "join/join";
    }
    @PostMapping("/join")
    public String postJoin (Join join, Model model) throws Exception{
        log.info("postJoin()");

        String pw = join.getPw();
        if(pw.length() < 8 ){
            return "redirect:/signup";
        }

        service.signup(join);

        model.addAttribute("msg", "회원가입이 완료되었습니다!");

        return "join/success";
    }
    @GetMapping("/login")
    public String getLogin (Join join, Model model) throws Exception{
        log.info("getLogin()");

        return "join/login";
    }
    @PostMapping("/login")
    public String postLogin (Join join, Model model) throws Exception{
        log.info("postLogin()");

        service.login(join);

        model.addAttribute("msg", "로그인이 완료되었습니다.");

        return "join/success";
    }

}

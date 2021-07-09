package com.example.personalProject2.controller;

import com.example.personalProject2.entity.Member;
import com.example.personalProject2.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


@Slf4j
@Controller
@RequestMapping("/member")
public class ControllerMember {

    @Autowired
    private MemberService service;

    @GetMapping("/register")
    public String getMemberRegister (Member member, Model model) {
        log.info("getMemberRegister()");

        return "/member/register";
    }

    @PostMapping("/register")
    public String postMemberRegister (Member member, Model model, HttpServletResponse response) throws Exception {
        log.info("postMemberRegister()");
        log.info("Member: " + member);

//        비밀번호 길이 체크 로직 시작
        String pw = member.getPw();
        if (pw.length() <= 8) {
            response.setCharacterEncoding("EUC-KR");
            PrintWriter writer = response.getWriter();
            writer.println("<script type='text/javascript'>");
            writer.println("alert('비밀번호를 다시 한번 확인해주세요');");
            writer.println("history.back();");
            writer.println("</script>");
            writer.flush();
            return "redirect:/member/register";

        }
//        비밀번호 길이 체크 로직 끝

        service.register(member);

        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "/board/success/success";
    }

    @GetMapping("/login")
    public String getLogin (Member member, Model model) {
        log.info("getLogin()");

        return "/member/login";
    }

    @PostMapping("/login")
    public String postLogin (Member member, Model model) throws Exception {
        log.info("postLogin(): " + member);

        service.login(member);

        model.addAttribute("msg", "로그인 성공!");

        return "/board/success/success";
    }
}
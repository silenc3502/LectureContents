package com.example.demo.controller.member;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.service.BoardService;
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
    public String getRegister(Member member, Model model){
        log.info("getRegister()");

        return "/member/register";
    }

    @PostMapping("/register")
    public String postRegister (Member member, Model model) throws Exception {
        log.info("getRegister()");
        log.info("Member:"+member);

        /*  비밀번호 체크 로직 시작*/
        String pw = member.getPassword();
        if(pw.length()<=8){
            //model.addAttribute("alertMsg","8자리 이상의 비밀번호를 기입해주세요");
            return "redirect:/member/register";
        }

        service.register(member);


        model.addAttribute("msg","등록이 완료 되었습니다!");

        return "/member/success";
    }

    @GetMapping("/lists")
    public String getLists(Model model) throws Exception {
        log.info("getLists()");

        model.addAttribute("lists",service.list());

        return "board/fifth/lists";
    }
}





package com.example.cholongtest.controller.membership;

import com.example.cholongtest.entity.Membership;
import com.example.cholongtest.service.BoardService;
import com.example.cholongtest.service.MembershipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/member")
public class MembershipController {

    @Autowired
    private MembershipService service;

    @GetMapping("/register")
    public String getMemberRegister (Membership membership, Model model) {
        log.info("getMemberRegister()");

        return "/membership/register";
    }

    @PostMapping("/register")
    public String postMemberRegister (Membership membership, Model model) throws Exception {
        log.info("postMemberRegister()");
        log.info("membership: " + membership);

        /* 비밀번호 길이 체크 로직 시작 */
        String pw = membership.getMemPassword();
        if (pw.length() <= 8) {
            // model.addAttribute("alertMsg", "8자리 이상의 비밀번호를 기입해주세요");
            return "redirect:/membership/register";
        }
        /* 비밀번호 길이 체크 로직 끝 */

        service.register(membership);

        model.addAttribute("signUp","회원 가입이 완료되었습니다!");

        return "/membership/success";
    }

    @GetMapping("/lists")
    public String getLists (Model model) throws Exception {
        log.info("getLists(): " + service.list());

        model.addAttribute("member", service.list());

        return "/membership/memIdLists";
    }

    @GetMapping("/login")
    public String getLogin (Membership membership, Model model) {
        log.info("getLogin()");

        return "/membership/login";
    }

    @PostMapping("/login")
    public String postLogin (Membership membership, Model model) throws Exception {
        log.info("postLogin(): " + membership);

        service.login(membership);

        model.addAttribute("msg", "로그인 성공!");

        return "/membership/success";
    }
}
package com.example.Project.controller.membership;


import com.example.Project.entity.Membership;
import com.example.Project.service.MembershipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberShipController {

    @Autowired
    private MembershipService membershipService;

    @GetMapping("/login")
    public String getM_Login() {
        log.info("getLogin");

        return "/membership/m_login";
    }

    @GetMapping("/m_register")
    public String getM_Register(Membership membership, Model model) throws Exception {
        log.info("getM_register()");

        return "/membership/m_register";
    }

    @GetMapping("/m_fail")
    public String getM_fail() {
        log.info("getM_fail()");
        return "/membership/m_fail";
    }

    @PostMapping("/m_register")
    public String postM_Membership(Membership membership, Model model) throws Exception {
        log.info("postM_Register()");
        log.info("membership: " + membership);

        /*비밀 번호 길이 체크 로직 시작*/
        String pw = membership.getPassword();
       if(pw.length() < 8){
         model.addAttribute("alertMsg", "8자리 이상의 비밀번호를 가입해주세요");
          return "redirect:/m_fail";
       }
        /*끝*/

        membershipService.M_register(membership);

        model.addAttribute("msg", "회원가입되었습니다.");

        return "/membership/m_success";
    }

    @GetMapping("/memberList")
    public String getMemberList(Model model) throws Exception {
        log.info("getMemberList()");

        model.addAttribute("lists", membershipService.list());

        return "/membership/memberList";
    }
}

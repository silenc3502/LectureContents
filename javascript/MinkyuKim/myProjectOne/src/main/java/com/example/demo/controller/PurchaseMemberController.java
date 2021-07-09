package com.example.demo.controller;

import com.example.demo.entity.PurchaseMember;
import com.example.demo.service.PurchaseMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class PurchaseMemberController {

    @Autowired
    private PurchaseMemberService purchaseMemberService;

    @GetMapping("/purchaseMemberSignUp")
    public String getPurchaseMemberSignUp(PurchaseMember purchaseMember, Model modelSignUp) {
        log.info("getPurchaseMemberSignUp()");

        return "/board/signUp/purchaseMemberSignUp";
    }
    @PostMapping("/purchaseMemberSignUp")
    public String postPurchaseMemberSignUp(PurchaseMember purchaseMember, Model model) throws Exception {
        log.info("postPurchaseMemberSignUp()");

        log.info("purchaseMemberSignUp: " + purchaseMember);

        /*
        String pw = purchaseMember.getPw();
        String pwCheck = purchaseMember.getPwCheck();
        if(pw != pwCheck) {
            return "/redirect:/signUp/purchaseMemberSignUp";
        }
         */

        purchaseMemberService.PurchaseMember(purchaseMember);

        // msg 라는 속성값에 "등록이 완료되었습니다!"을 맵핑함
        // key: msg, value: "등록이 완료되었습니다!" 라고 생각하면 편함
        model.addAttribute("signUpMSG", "회원가입이 완료되었습니다!");

        return "/board/signUp/signUpComplete";
    }

   /* @PostMapping("/purchaseMemberSignUp")
    public String postPurchaseMemberSignUp(PurchaseMember purchaseMember, Model model) throws Exception {
        log.info("postPurchaseMemberSignUp()");

        log.info("purchaseMemberSignUp: " + purchaseMember);

        purchaseMemberService.PurchaseMember(purchaseMember);

        // msg 라는 속성값에 "등록이 완료되었습니다!"을 맵핑함
        // key: msg, value: "등록이 완료되었습니다!" 라고 생각하면 편함
        model.addAttribute("signUpMSG", "회원가입이 완료되었습니다!");

        return "/board/signUp/signUpComplete";
    } <<원본내역
*/
    // 비밀번호 체크로직
    /* @PostMapping("/pwCheck")
    public String postPwCheck(PurchaseMember purchaseMember, Model model) throws Exception {
        log.info("postPwCheck()");

        String pw = purchaseMember.getPw();
        String pwCheck = purchaseMember.getPwCheck();
        if(pw != pwCheck) {
            return "/redirect:/signUp/purchaseMemberSignUp";
        }
        purchaseMemberService.PurchaseMember(purchaseMember);

        model.addAttribute("signUpMSG", "회원가입이 완료되었습니다!");

        return "/board/signUp/signUpComplete";

    }
 조건문을 위에넣어야한다. */
}

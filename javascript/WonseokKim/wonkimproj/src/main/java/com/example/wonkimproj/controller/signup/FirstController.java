package com.example.wonkimproj.controller.signup;

import com.example.wonkimproj.entity.SignUp;
import com.example.wonkimproj.service.SignupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class FirstController {
    @Autowired
    private SignupService service;

    @GetMapping("/register")
    public String getSignup (SignUp signup, Model model) {
        log.info("getRegister()");

        return "/signup/first/register";
    }

    @PostMapping("/register")
    public String postSignup (SignUp signup, Model model) throws Exception {
        log.info("postRegister()");
        log.info("SignUp: " + signup);

        service.register(signup);

        model.addAttribute("msg", "가입을 환영합니다!");

        return "/signup/first/success";
    }

    @GetMapping("/mainPage")
    public String getMainPage () {
        log.info("getMainPage()");

        return "/signup/first/mainPage";
    }
}

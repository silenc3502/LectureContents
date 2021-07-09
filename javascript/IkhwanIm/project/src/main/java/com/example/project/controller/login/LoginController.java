package com.example.project.controller.login;

import com.example.project.entity.Login;
import com.example.project.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping("/register")
    public String getRegister (Login login, Model model) {
        log.info("getRegister()");

        return "/login/register";
    }

    @PostMapping("/register")
    public String loginRegister (Login login, Model model) throws Exception {
        log.info("LoginRegister()");
        log.info("Login: " + login);

        service.register(login);

        model.addAttribute("msg","등록이 완료되었습니다!");

        return "/login/success";
    }
}

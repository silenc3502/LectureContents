package com.example.demo.newcontroller.NagNetcontroller;

import com.example.demo.entity.NagetloningTest;
import com.example.demo.service.loginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class NagnetController {

    @Autowired
    private loginService service;

    @GetMapping("/nag")
    public String getNagNet(NagetloningTest nagetloningtest , Model model){
        log.info("NagNet()");

        return "/Test/NagNet/loginsite";
    }
    @PostMapping("/nag")
    public  String postNagNet(NagetloningTest nagetloningtest , Model model) throws Exception {

        log.info("postNagNet()");

        log.info("NagetloningTest:"+nagetloningtest);
                service.login(nagetloningtest);

                model.addAttribute("msg","나그넷의 회원이되신것을 축하합니다.");

                return "/Test/NagNet/loginsuccess";
    }

}

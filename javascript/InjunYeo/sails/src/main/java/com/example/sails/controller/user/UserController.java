package com.example.sails.controller.user;

import com.example.sails.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

    @GetMapping("/register")
    public String userRegister(User user, Model model){
        log.info("userRegister()");

        return "/user/userRegister";

    }




}

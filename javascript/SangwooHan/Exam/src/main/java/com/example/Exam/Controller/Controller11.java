package com.example.Exam.Controller;

import com.example.Exam.entity.Usermarket;


import com.example.Exam.service.UsermarketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class Controller11 {


  // @Autowired
   // private UsermarketService service;
    @GetMapping("/register")
    public String getRegister (Usermarket usermarket, Model model) {
        log.info("getRegister()");

        return "/Usermarket/register";
    }

    @PostMapping("/register")
    public String postRegister (Usermarket usermarket, Model model) throws Exception {

        log.info("postRegister()");

        log.info("usermarket:" + usermarket);


       // service.bomdong2(usermarket);

        return "/Usermarket/success";
    }



    @GetMapping("/lists")
    public String getlist (Model model) throws Exception{
      // log.info("getList():"+service.list());

     //   model.addAttribute("usermarket",service.list());

        return "/Usermarket/lists";
    }

}

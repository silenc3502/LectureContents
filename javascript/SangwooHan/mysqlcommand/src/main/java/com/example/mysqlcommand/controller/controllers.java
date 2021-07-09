package com.example.mysqlcommand.controller;

import com.example.mysqlcommand.entity.Command;
import com.example.mysqlcommand.service.sqlcommandservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class controllers {

    @Autowired
    private sqlcommandservice service;

    @GetMapping("/register")
    public  String getregister(Command command, Model model){
        log.info("getregister()");

        return "/command/register";
    }

    @PostMapping("/register")
    public String postregister(Command command, Model model) throws  Exception{
        log.info("postregister()");

        log.info("stagbeetle:" +command);

        service.register(command);


        return "/command/success";
    }

    @GetMapping("/lists")
    public String lists(Model model) throws  Exception{
        log.info("lists():" +service.list());

        model.addAttribute("command",service.list());

        return "/command/lists";
    }
}

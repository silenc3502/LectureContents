package com.example.sasuem.controller;

import com.example.sasuem.entity.Stagbeetle;
import com.example.sasuem.service.insectdiagramservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class sasuemController {

   @Autowired
   private insectdiagramservice service;

    @GetMapping("/register")
    public  String getregister(Stagbeetle stagbeetle, Model model){
        log.info("getregister()");

        return "/insect/register";
    }

    @PostMapping("/register")
    public String postregister(Stagbeetle stagbeetle, Model model) throws  Exception{
        log.info("postregister()");

        log.info("stagbeetle:" +stagbeetle);

        service.register(stagbeetle);


        return "/insect/success";
    }

    @GetMapping("/lists")
    public String lists(Model model) throws  Exception{
     log.info("lists():" +service.list());

     model.addAttribute("stagbeetle",service.list());

     return "/insect/lists";
    }
}

package com.example.demo.controller;

import com.example.demo.entity.Concert;
import com.example.demo.service.ConcertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ConcertController {

    @Autowired
    private ConcertService service;

    @GetMapping("/concertRegister")
    public String getConcertRegister(Concert concert, Model model) {
        log.info("register()");

        return "/concert/concertRegister";
    }

    @PostMapping("/concertRegister")
    public String postConcertRegister(Concert concert, Model model) {
        log.info("postRegisterSuccess()");
        log.info("새로 등록된 concert: " + concert);

        service.register(concert);
        model.addAttribute("msg", "등록 완료");

        return "/concert/registerSuccess";
    }

    @GetMapping("/concertList")
    public String getConcertList(Model model) throws Exception{
        log.info("getConcertList(): " + service.list());

        model.addAttribute("concertList", service.list());

        return "/concert/concertList";
    }

}
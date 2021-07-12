package com.example.memberShipTest.controller.homework;

import com.example.memberShipTest.eutity.Homework;
import com.example.memberShipTest.service.HomeworkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class HomeWorkController {

    @Autowired
    private HomeworkService service;


    @GetMapping("/prob66")
    public String getProb66(Homework homework, Model model) {
        log.info("getProb66()");

        return "/homework/prob66";
    }

    @PostMapping("/prob66")
    public String postProb66(Homework homework, Model model) throws Exception {
        log.info("postProb66()");

        log.info("HomeWork: " + homework);

        service.prob66(homework);

        // msg 라는 속성값에 "등록이 완료되었습니다!"을 맵핑함
        // key: msg, value: "등록이 완료되었습니다!" 라고 생각하면 편함
        model.addAttribute("msg", "가입이 완료되었습니다!");

        return "/homework/joinSuccess";
    }
}

package com.example.jswithspring.controller.member;

import com.example.jswithspring.entity.MemberSevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("")
public class MemberController {

    private MemberSevice service;
}

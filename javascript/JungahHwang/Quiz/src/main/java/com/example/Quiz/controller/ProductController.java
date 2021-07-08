package com.example.Quiz.controller;

import com.example.Quiz.entity.Product;
import com.example.Quiz.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/register")
    public String getRegister (Product product, Model model) throws Exception{

        log.info("getRegister()");

        return "product/register";
    }

    @PostMapping("/register")
    public String registerForm (Product product, Model model) throws Exception {
        log.info("postRegister()" + product);

        service.register(product);

        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "product/success";
    }
    @GetMapping("/lists")
    public String getLists (Model model) throws Exception {
        log.info("getLists(): " + model);

        model.addAttribute("lists", service.list());

        return "product/lists";
    }
}

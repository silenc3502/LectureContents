package com.example.practice2.controller;

import com.example.practice2.entity.Product;
import com.example.practice2.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MainController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String mainPage(){
        log.info("mainPage()");

        return "main";
    }

    @GetMapping("/register")
    public String getRegister(Product product, Model model){
        log.info("getRegister()");

        return "product/register";
    }

    @PostMapping("/register")
    public String postRegister(Product product, Model model) throws Exception {
        log.info("postRegister()");
        log.info("Product:"+product);

        service.register(product);
        model.addAttribute("msg","등록이 완료되었습니다.");

        return "product/success";
    }

    @GetMapping("/lists")
    public String getLists(Model model) throws Exception{
        log.info("getLists()");

        model.addAttribute("lists",service.lists());

        return "product/lists";
    }
}

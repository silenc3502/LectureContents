package com.example.pratice3.controller;


import com.example.pratice3.entity.Product;
import com.example.pratice3.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private ProductService service;


    @GetMapping("/")
    public String mainPage(){
        log.info("mainPage");

        return "main";
    }

    @GetMapping("/register")
    public String getRegister(Product product, Model model){
        log.info("getRegister()");

        return "product/register";
    }

    @PostMapping("/register")
    public String postRegister(Product product,Model model) throws Exception {
        log.info("postRegister()");

        service.register(product);
        return "product/success";
    }

    @GetMapping("/lists")
    public String getLists(Model model) throws Exception {

        log.info("getList()");
        model.addAttribute("lists",service.lists());

        return "product/lists";
    }


}

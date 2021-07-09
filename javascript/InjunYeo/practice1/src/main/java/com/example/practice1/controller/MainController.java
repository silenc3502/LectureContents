package com.example.practice1.controller;

import com.example.practice1.entity.Product;
import com.example.practice1.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.*;

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

        return "/product/register";
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
    public String getLists(Model model) throws Exception {
        log.info("getLists()");

        model.addAttribute("lists",service.lists());

        return "product/lists";
    }

    @GetMapping("/read")
    public String getRead(Integer productNo,Model model) throws Exception{
        log.info("read()"+productNo);

        //service.read로 바로 전달해주는건 안되는가?
        model.addAttribute(service.read(productNo));

        return "product/read";


    }

    @PostMapping("/remove")
    public String postRemove(Integer productNo, Model model) throws Exception{
        log.info("remove");

        service.remove(productNo);
        model.addAttribute("msg","삭제가 완료되었습니다");

        return "product/success";
    }
}

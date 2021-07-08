package com.example.project1.controller;

import com.example.project1.entity.Product;
import com.example.project1.service.ProductService;
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
    public String getRegister (Product product, Model model) {
        log.info("getRegister()");

        return "/product/register";
    }

    @PostMapping("/register")
    public String postRegister (Product product, Model model) throws Exception {
        log.info("postRegister()");
        log.info("Product: " + product);

        service.register(product);
        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "/product/productSuccess";
    }

    @GetMapping("/lists")
    public String getLists (Model model) throws Exception {
        log.info("getLists(): " + service.list());

        model.addAttribute("product", service.list());

        return "/product/lists";
    }
    @GetMapping("/read")
    public String getRead (int productNo, Model model) throws Exception {
        log.info("read");

        model.addAttribute(service.read(productNo));

        return "/product/read";
    }
    @PostMapping("/remove")
    public String remove (int productNo, Model model) throws Exception{
        log.info("remove");

        service.remove(productNo);

        model.addAttribute("msg", "삭제가 완료되었습니다!");

        return "/product/productSuccess";
    }
    @GetMapping("/modify")
    public String getModify (int productNo, Model model) throws Exception{
        log.info("getModify()");

        // 수정을 눌렀을때 기존 정보를 가져와야함
        model.addAttribute(service.read(productNo));

        return "/product/modify";
    }

    @PostMapping("/modify")
    public String modify (Product product, Model model) throws Exception{
        log.info("postModify()");

        service.modify(product);
        model.addAttribute("msg", "수정이 성공적으로 완료되었스니다!");

        return "/product/productSuccess";
    }


}
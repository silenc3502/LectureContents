package com.example.productList.controller;

import com.example.productList.entity.Product;
import com.example.productList.service.ProductListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class FirstController {
    @Autowired
    private ProductListService service;

    @GetMapping("/shopRegister")
    private String getShopRegister (Product product, Model model) {
        log.info("getShopRegister()");

        return "/product/register";
    }

    @PostMapping("/shopRegister")
    public String postShopRegister (Product product, Model model) throws Exception {
        log.info("postRegister()");
        log.info("Product: " + product);

        service.register(product);

        model.addAttribute("msg", "상품 등록이 완료되었습니다!");

        return "/product/success";
    }
    @GetMapping("/shopLists")
    public String getLists (Model model) throws Exception {
        log.info("getLists(): " + service.list());

        model.addAttribute("shopLists", service.list());

        return "/product/shopLists";
    }

    @GetMapping("/read")
    public String getRead (int productNo, Model model) throws Exception{
        log.info("read");
        model.addAttribute(service.read(productNo));
        return "product/read";

    }

    @PostMapping("/remove")
    public String remove(int productNo, Model model) throws Exception {
        log.info("remove");


        service.remove(productNo);
        model.addAttribute("msg", "삭제가 완료되었습니다. ");
        return "product/success";
    }
}



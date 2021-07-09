package com.example.SoloProject.controller;

import com.example.SoloProject.entity.Product;
import com.example.SoloProject.service.ProductService;
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
    private ProductService productservice;

    @GetMapping("/productregister")
    public String getProduct (Product product, Model model) throws Exception {
        log.info("getProduct(): " + productservice.productlist());

        model.addAttribute("productlists", productservice.productlist());

        return "/product/productregister";
    }

    @PostMapping("/productregister")
    public String postProduct (Product product, Model model) throws Exception {
        log.info("postProduct()");
        log.info("Product: " + product);

        productservice.productregister(product);

        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "/product/success";
    }

    @GetMapping("/productlist")
    public String getProductlist (Model model) throws Exception {
        log.info("getProductlist(): " + productservice.productlist());

        model.addAttribute("product", productservice.productlist());

        return "/product/productlist";
    }

    @GetMapping("/productread")
    public String getProductRead (int productNo, Model model) throws Exception{
        log.info("productread(): productNo = " + productNo);

        model.addAttribute(productservice.productread(productNo));

        return "/product/productread";
    }

    // 글을 지워도 숫자가 올라가야만 하는 이유가 무엇인가?
    // 배열 100개에서 중간의 값을 지우는 경우가 있는가
    // 애초에 중간에 지워진 값을 채우는 것 또한 큰 낭비다
    @PostMapping("/productremove")
    public String productremove (int productNo, Model model) throws Exception{
        log.info("productremove()");

        productservice.productremove(productNo);

        model.addAttribute("msg", "삭제가 완료되었습니다");

        return "/product/success";
    }
}

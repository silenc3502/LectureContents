
package com.example.project.controller.product;

import com.example.project.entity.Product;
import com.example.project.service.ProductService;
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

        return "/product/success";
    }

    @GetMapping("/lists")
    public String getLists (Model model) throws Exception {
        log.info("getLists()");

        model.addAttribute("product", service.list());

        return "/product/lists";
    }

    @GetMapping("/movietest")
    public String getmovietest() {
        log.info("getmovietest()");
        return "/movietest";
    }


    @GetMapping("/rogin")
    public String getRogin() {
        log.info("getRogin()");

        return "/rogin/roginRegister";
    }
}




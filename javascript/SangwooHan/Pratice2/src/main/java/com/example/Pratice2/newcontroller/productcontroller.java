package com.example.Pratice2.newcontroller;

import com.example.Pratice2.entity.Product;
import com.example.Pratice2.sevice.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class productcontroller {


   @Autowired
    private ProductService service;
    @GetMapping("/register")
    public String getRegister (Product product, Model model) {
        log.info("getRegister()");

        return "/Product/register";
    }

    @PostMapping("/register")
    public String postRegister (Product product, Model model) throws Exception {

        log.info("postRegister()");

        log.info("product:" + product);


      service.register(product);

        return "/Product/success";
    }



    @GetMapping("/lists")
    public String getlist (Model model) throws Exception{
        log.info("getList():"+service.list());

        model.addAttribute("product",service.list());

        return "/Product/lists";
    }

}

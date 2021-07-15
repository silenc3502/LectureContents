package com.example.demo.Controller.Product;


import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
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
    @GetMapping("/lists")
    public String getLists (Model model) throws Exception {
        log.info("getlists()");

        model.addAttribute("lists",service.list());

        return "/Product/lists";
    }
    @GetMapping("/register")
    public String getRegister (Product product, Model model) {
        log.info("getRegister()");

        return "/Product/register";
    }


    @PostMapping("/register")
    public String postRegister (Product product, Model model) throws Exception {
        log.info("postRegister()");
        log.info("Product: " + product);

        service.register(product);

        model.addAttribute("product", "등록이 완료되었습니다!");

        return "/Product/success";
    }


}

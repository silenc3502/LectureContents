package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("sales")
    public String getSales (ProductController salesBoard, Model model) {
        log.info("getSales()");

        return "/board/salesList";
    }
}

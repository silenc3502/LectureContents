package com.example.project.controller.item;

import com.example.project.entity.Item;
import com.example.project.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping("/registerItem")
    public String getRegisterItem (Item item, Model model) {
        log.info("getRegisterItem()");

        return "/item/register";
    }

    @PostMapping("/registerItem")
    public String postRegisterItem (Item item, Model model) throws Exception {
        log.info("postRegisterItem()");
        log.info("Item: " + item);

        service.registerItem(item);

        model.addAttribute("msg","등록이 완료되었습니다!");

        return "/item/success";
    }
    @GetMapping("/list")
    public String getList (Model model) throws Exception {
        log.info("getList(): " + service.list());
        model.addAttribute("list", service.list());

        return "/item/list";
    }
}

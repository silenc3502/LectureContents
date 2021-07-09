package com.example.quest.controller.questController;
import com.example.quest.eutity.Market;
import com.example.quest.service.MarketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
public class QuestController {

   @Autowired
    private MarketService service;

    @GetMapping("/register")
    public String getMarket(Market market, Model model) {
        log.info("getRegister()");

        return "/questHTML/register";
    }


    @PostMapping("/register")
    public String postRegister(Market market, Model model) throws Exception {
        log.info("postRegister()");
        log.info("Market: " + market);

        service.register(market);

        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "/questHTML/success";
    }
    @GetMapping("/lists")
    public String getLists(Model model) throws Exception{
        log.info("getLists()");

        model.addAttribute("lists", service.list());

        return "/questHTML/lists";
    }
}
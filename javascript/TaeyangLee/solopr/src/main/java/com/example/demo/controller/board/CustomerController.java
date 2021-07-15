package com.example.demo.controller.board;


import com.example.demo.entity.Board;
import com.example.demo.entity.Customer;
import com.example.demo.service.BoardService;
import com.example.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/join")
    public String getJoin (Customer customer, Model model) {
        log.info("getJoin()");

        return "/customer/join";
    }


    @PostMapping("/join")
    public String postJoin (Customer customer, Model model) throws Exception {
        log.info("postJoin()");
        log.info("customer: " + customer);

        String pw = customer.getPassword();

        if(pw.length() <= 8) {
            return "redirect:/customer/join";
        }

        customerService.join(customer);

        // msg 라는 속성값에 "등록이 완료되었습니다!"을 맵핑함
        // key: msg, value: "등록이 완료되었습니다!" 라고 생각하면 편함
        model.addAttribute("msg", "등록이 완료되었습니다!");

        return "/customer/joinsuccess";
    }
    @GetMapping("/login")
    public String getLogin (Customer customer, Model model) {
        log.info("getLogin()");

        return "/customer/login";
    }

    @PostMapping("/login")
    public String postLogin (Customer customer, Model model) throws Exception {
        log.info("postLogin(): " + customer);

        customerService.login(customer);

        model.addAttribute("msg", "로그인 성공!");

        return "/customer/joinsuccess";
    }


    @GetMapping("/lists")
    public String getLists (Model model) throws Exception {
        log.info("getLists(): " + customerService.list());

        model.addAttribute("customer", customerService.list());

        return "/customer/customerIdList";
    }



}

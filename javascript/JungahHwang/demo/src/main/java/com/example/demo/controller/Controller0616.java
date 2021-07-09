package com.example.demo.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class Controller0616 {
    @GetMapping("/checkbox")
    public String checkbox () {
        log.info("checkbox");

        return "Review0616/checkbox";
    }
    @GetMapping("/radioTest")
    public String radioTest () {
        log.info("radioTest");

        return "Review0616/radioTest";
    }
    @GetMapping("/formRadio")
    public String formRadio () {
        log.info("formRadio");

        return "Review0616/formRadio";
    }
    @GetMapping("/test")
    public String test(){
        log.info("test");

        return "redirect:/";
        // redirect: -> 특정한 URL 위치로 맵핑
    }
    @GetMapping("/fieldsetLogin")
    public String fieldsetLogin () {
        log.info("fieldsetLogin");

        return "Review0616/fieldsetLogin";
    }
    @GetMapping("/numberRange")
    public String numberRange () {
        log.info("numberRange");

        return "Review0616/numberRange";
    }
    @GetMapping("/button")
    public String button () {
        log.info("button");

        return "Review0616/button";
    }
    // * postMapping 전송 포멧: json 형태를 전달 *
    @GetMapping("/select")
    public String select () {
        log.info("select");

        return "Review0616/select";
    }
    @GetMapping("/optgroup")
    public String optgroup () {
        log.info("optgroup");

        return "Review0616/optgroup";
    }

}

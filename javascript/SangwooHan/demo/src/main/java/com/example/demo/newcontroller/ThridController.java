package com.example.demo.newcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ThridController {

    @GetMapping("/checkboxTest")
    public  String checkboxTest(){
        log.info("checkboxTest()");

        return "/third/checkbox";
    }

    @GetMapping("/radioTest")
    public String radioTest(){
        log.info("radioTest()");

        return "/third/radio";
    }
  @GetMapping("/formradioTest")
    public String formRadioTest(){
        log.info("formRadioTest()");

        return "/third/formradio";
  }
 @GetMapping("/test")
    public String test(){
        log.info("test()");

        return "redirect:/";
 }
 @GetMapping("/fieldsetlogin")
    public String fieldsetlogin(){
        log.info("fieldsetlogin()");

        return "/third/fieldsetlogin";

 }
 @GetMapping("/NumberRange")
    public String NumberRang() {
     log.info("NumberRange()");

     return "/third/NumberRange";
 }
        @GetMapping("/buttonTest")
                public String buttonTest(){
            log.info("buttonTest");

            return "/third/buttonTest";
     }


    @GetMapping("/optgroupTest")
    public String optgroupTest(){
        log.info("optgroupTest()");

        return "/third/optgroup";
    }

    @GetMapping("/homeWorkTest")
    public  String homeWorkTest(){
        log.info("homeWork()");

        return "/third/homeWorkTest";
    }
    @GetMapping("/NagNet")
    public  String NagNet(){
        log.info("NagNet()");

        return "/third/NagNet";
    }

}

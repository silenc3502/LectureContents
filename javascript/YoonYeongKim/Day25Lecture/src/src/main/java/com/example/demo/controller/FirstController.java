package src.main.java.com.example.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FirstController {

    @GetMapping("/HtmlList")
    public String doHtmlList () {
        log.info("doHtmlList()");

        return "first/List.html";
    }

    @GetMapping("/imageTest")
    public String doImageTest () {
        log.info("doImageTest()");

        return "first/image.html";
    }

    @GetMapping("/fontTest")
    public String doFontTest () {
        log.info("doFontTest()");

        return "first/font";
    }

    @GetMapping("/markTest")
    public String doMarkTest () {
        log.info("doMarkTest()");

        return "first/mark";
    }

    @GetMapping("/firstTableTest")
    public String doFirstTableTest () {
        log.info("doFirstTableTest()");

        return "first/tableTest1";
    }

    @GetMapping("/secondTableTest")
    public String doSecondTableTest () {
        log.info("doSecondTableTest()");

        return "first/tableTest2";
    }

    @GetMapping("/thirdTableTest")
    public String doThirdTableTest () {
        log.info("doThirdTableTest()");

        return "first/tableTest3";
    }

    @GetMapping("/fourthTableTest")
    public String doFourthTableTest () {
        log.info("doFourthTableTest()");

        return "first/resumeTest";
    }


}

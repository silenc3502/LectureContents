package com.example.demo.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j
@Controller
public class FirstController_20210611 {

    // 'Get' / 'Post' > 실제 웹상에서 URL 요청할 때 자주 사용하는 두 가지 방식.
    // 일반적인 URL 입력은 Get이라고 파악해둘 것.
    // @GetMapping("/") > ip:port의 Home > 'naver.com/' = 'naver.com'
    @GetMapping("/fail")
    //GetMapping은 바로 아래의 method까지만 바라봄(?)
    public String dofail(){
        log.info("dofail() 실행");
        return "fail";
    }

    @GetMapping("/htmlList")
    public String doHtmlList(){
        log.info("doHtmlList()");
        return "First_20210611/list";
    }

    @GetMapping("/imageTest")
        public String doImageTest(){
            log.info("doImagetTest");
            return "First_20210611/image";
        }

    @GetMapping("/fontTest")
    public String doFontTest(){
        log.info("doFontTest");
        return "First_20210611/font";
    }

    @GetMapping("/markTest")
    public String domarkTest(){
        log.info("domarkTest");
        return "First_20210611/mark";
    }

    @GetMapping("/tableTest1")
    public String dotableTest1(){
        log.info("dotableTest1");
        return "First_20210611/tableTest1";
    }

    @GetMapping("/tableTest2")
    public String dotableTest2(){
        log.info("dotableTest2");
        return "First_20210611/tableTest2";
    }

    @GetMapping("/tableTest3")
    public String dotableTest3(){
        log.info("dotableTest3");
        return "First_20210611/tableTest3";
    }

    @GetMapping("/resume")
    public String doresume(){
        log.info("doresume");
        return "First_20210611//resume";
    }
}

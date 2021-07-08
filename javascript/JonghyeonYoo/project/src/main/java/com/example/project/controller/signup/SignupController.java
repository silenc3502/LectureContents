
package com.example.project.controller.signup;

import com.example.project.entity.Signup;
import com.example.project.service.SignupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/css")
public class SignupController {

    // 스프링이 자동으로 객체를 찾을 수 있게 서포트함
    @Autowired
    private SignupService service;

    // thymeleaf에서는 아래와 같이 특정한 객체를 입력으로 받으면
    // HTML에서 th:object와 같은 키워드를 통해 정보를 획득할 수 있다.
    // 즉 signup 객체의 정보를 획득할 수 있음을 의미한다.
    @GetMapping("/signupregister")
    public String getsignupRegister (Signup signup, Model model) {
        log.info("getsignupRegister()");

        return "/member/signupregister";
    }

    // MVC(Model View Controller) Pattern
    // Model: 다루는 데이터
    // View: 눈에 보이는 화면
    // Controller: URL 제어

    @PostMapping("/signupregister")
    public String postsignupRegister (Signup signup, Model model) throws Exception {
        log.info("postsignupRegister()");
        log.info("Signup: " + signup);

        service.register(signup);

        // msg 라는 속성값에 "회원가입을 축하합니다!"을 맵핑함
        // key: msg, value: "회원가입을 축하합니다!" 라고 생각하면 편함
        model.addAttribute("msg", "회원가입을 축하합니다!");
        return "/signup/success";
    }
}


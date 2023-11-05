package com.example.jswithspring.controller.jpatest;

import com.example.jswithspring.controller.vue.jpa.request.MemberRequest;
//import com.example.jswithspring.entity.jpa.Member;
import com.example.jswithspring.entity.jpa.ManyToManyMember;
import com.example.jswithspring.service.jpa.JPAManyToManyTestMemberService;
import com.example.jswithspring.service.jpa.JPAMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("jpamembertest")
public class JpaTestController {
    static int cnt = 0;

    @Autowired
    private JPAManyToManyTestMemberService service;

    @GetMapping("member")
    public String insertMember () throws Exception {
        MemberRequest memberRequest = new MemberRequest("id" + (++cnt), "pw", "ROLE_BUSINESS");
        MemberRequest memberRequest2 = new MemberRequest("id" + (++cnt), "pw", "ROLE_CUSTOMER");

        service.register(memberRequest);
        service.register(memberRequest2);

        return "Insert Success";
    }

    @GetMapping("checkBusiness")
    public String checkBusinessMember () {
        List<ManyToManyMember> businessMember = service.findBusiness();

        for (ManyToManyMember member : businessMember) {
            //log.info("member id: " + member.getUserId());
            log.info(String.valueOf(member));
        }

        return "Check Finish";
    }
}

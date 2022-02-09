package com.example.jswithspring.service.jpa;

import com.example.jswithspring.controller.vue.jpa.request.MemberRequest;
import com.example.jswithspring.entity.jpa.ManyToManyMember;
//import com.example.jswithspring.entity.jpa.Member;

import java.util.List;
import java.util.Optional;

public interface JPAManyToManyTestMemberService {

    public void register(MemberRequest memberRequest) throws Exception;
    public List<ManyToManyMember> findBusiness();
}

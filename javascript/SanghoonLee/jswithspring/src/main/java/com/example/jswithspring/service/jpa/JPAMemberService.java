package com.example.jswithspring.service.jpa;

import com.example.jswithspring.entity.jpa.Member;

import java.util.List;

public interface JPAMemberService {
    public void register(Member member) throws Exception;
    /*
    public void login(Member member) throws Exception;
    public List<Member> list() throws Exception;
     */
}

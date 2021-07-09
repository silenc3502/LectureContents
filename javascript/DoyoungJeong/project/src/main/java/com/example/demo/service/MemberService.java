package com.example.demo.service;

import com.example.demo.entity.Member;

import java.util.List;

public interface MemberService {
    public void memberSignup(Member member) throws Exception;
    public List<Member> list() throws Exception;
    public Boolean loginCheck(Member member) throws Exception;
}

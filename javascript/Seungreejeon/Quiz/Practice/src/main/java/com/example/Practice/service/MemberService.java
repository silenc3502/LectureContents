package com.example.Practice.service;

import com.example.Practice.domain.Member;

import java.util.List;

public interface MemberService {

    public void enroll(Member member);

    List<Member> lists();
}

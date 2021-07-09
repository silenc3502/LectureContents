package com.example.first.service;

import com.example.first.entity.Member;

public interface MemberService {
    public void register(Member member) throws Exception;
    public void login(Member member) throws Exception;
}
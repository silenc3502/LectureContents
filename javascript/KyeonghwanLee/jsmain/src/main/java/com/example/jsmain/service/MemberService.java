package com.example.jsmain.service;

import com.example.jsmain.entity.Member;

public interface MemberService {
    public void register(Member member) throws Exception;
    public void login(Member member) throws Exception;
}
package com.example.personalProject2.service;

import com.example.personalProject2.entity.Member;

public interface MemberService {
    public void register(Member member) throws Exception;
    public void login(Member member) throws Exception;

}
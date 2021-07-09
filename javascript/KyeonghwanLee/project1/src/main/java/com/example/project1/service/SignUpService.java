package com.example.project1.service;

import com.example.project1.entity.Member;

public interface SignUpService {
    public void signup(Member member) throws Exception;
    public void login(Member member) throws Exception;
}
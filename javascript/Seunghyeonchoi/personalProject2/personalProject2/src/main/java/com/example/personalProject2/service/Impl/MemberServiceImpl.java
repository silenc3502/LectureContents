package com.example.personalProject2.service;

import com.example.personalProject2.entity.Member;
import com.example.personalProject2.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Override
    public void register(Member board) throws Exception {
        repository.create(board);
    }
    @Override
    public void login(Member member) throws Exception {
        repository.login(member);
    }
}
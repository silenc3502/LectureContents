package com.example.Quiz.service;

import com.example.Quiz.entity.Member;
import com.example.Quiz.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository repository;

    @Override
    public void signup(Member member) throws Exception{
        repository.create(member);
    }
    @Override
    public void login(Member member) throws Exception{
        repository.login(member);
    }
    public List<Member> memberList() throws Exception{
        return repository.memberList();
    }
}

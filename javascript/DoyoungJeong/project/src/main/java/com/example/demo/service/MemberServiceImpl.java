package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository repository;

    @Override
    public void memberSignup(Member member) throws Exception { //임시로 throws 해놓음
        repository.create(member);
    }

    @Override
    public List<Member> list() throws Exception {
        return repository.list();
    }

    @Override
    public Boolean loginCheck(Member member) throws Exception {
        repository.loginCheck(member);
        return repository.loginCheck(member);
    }
}

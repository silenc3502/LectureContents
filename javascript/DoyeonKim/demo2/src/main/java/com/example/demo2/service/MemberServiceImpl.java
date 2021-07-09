package com.example.demo2.service;

import com.example.demo2.entity.Member;
import com.example.demo2.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Override
    public List<Member> list() throws Exception {
        return repository.list();
    }
}
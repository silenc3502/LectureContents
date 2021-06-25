package com.example.jswithspring.service;

import com.example.jswithspring.entity.Member;
import com.example.jswithspring.repository.MemberRepository;
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
}
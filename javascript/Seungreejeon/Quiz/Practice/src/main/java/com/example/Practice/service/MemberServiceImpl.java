package com.example.Practice.service;

import com.example.Practice.domain.Member;
import com.example.Practice.repository.Member_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private Member_Repository memberRepository;

    @Override
    public void enroll(Member member) {
        memberRepository.create(member);
    }

    @Override
    public List<Member> lists() {
        return memberRepository.lists();
    }

}

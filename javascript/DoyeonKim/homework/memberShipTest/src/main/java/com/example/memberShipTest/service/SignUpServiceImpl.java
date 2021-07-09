package com.example.memberShipTest.service;

import com.example.memberShipTest.entity.Member;
import com.example.memberShipTest.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private SignUpRepository repository;

    @Override
    public void signup(Member member) {
        repository.create(member);
    }
}
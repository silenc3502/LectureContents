package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements com.example.demo.service.SignUpService {

    @Autowired
    private SignUpRepository repository;

    @Override
    public void signup(Member member) {
        repository.create(member);
    }
}
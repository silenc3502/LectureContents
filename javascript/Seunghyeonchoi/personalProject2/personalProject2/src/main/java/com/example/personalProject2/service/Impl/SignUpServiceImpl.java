package com.example.personalProject2.service.Impl;

import com.example.personalProject2.entity.Member;
import com.example.personalProject2.repository.SignUpRepository;
import com.example.personalProject2.service.SignUpService;
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
package com.example.wonkimproj.service;

import com.example.wonkimproj.entity.SignUp;
import com.example.wonkimproj.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupServiceImpl implements SignupService{

    @Autowired
    private SignupRepository repository;

    @Override
    public void register(SignUp signup) throws Exception {
        repository.create(signup);
    }
}

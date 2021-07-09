package com.example.project.service;

import com.example.project.entity.Product;
import com.example.project.entity.RoginMember;
import com.example.project.entity.Signup;
import com.example.project.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignupServiceImpl implements SignupService {

    @Autowired
    private SignupRepository repository;

   @Override
    public void register(Signup signup) throws Exception {
        repository.create(signup);
    }
}
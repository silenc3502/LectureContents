package com.example.wonkimproj.service;

import com.example.wonkimproj.entity.SignUp;

import org.springframework.stereotype.Service;

public interface SignupService {
    public void register(SignUp signup) throws Exception;
}

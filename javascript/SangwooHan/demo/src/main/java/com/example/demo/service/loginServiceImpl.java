package com.example.demo.service;

import com.example.demo.entity.NagetloningTest;
import com.example.demo.repository.NagNetReopsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginServiceImpl implements  loginService {
    @Autowired
    private NagNetReopsitory reopsitory;

    @Override
    public void login(NagetloningTest nagetloningtest) throws  Exception{
       reopsitory.creates(nagetloningtest);
    }
}

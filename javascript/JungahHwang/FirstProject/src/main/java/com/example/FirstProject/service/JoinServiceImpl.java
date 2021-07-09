package com.example.FirstProject.service;

import com.example.FirstProject.entity.Join;
import com.example.FirstProject.repository.JoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinServiceImpl implements JoinService {

    @Autowired
    private JoinRepository repository;

    @Override
    public void signup(Join join) throws Exception{
        repository.create(join);
    }
    @Override
    public void login(Join join) throws Exception{
        repository.login(join);
    }

}

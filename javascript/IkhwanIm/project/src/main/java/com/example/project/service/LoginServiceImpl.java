package com.example.project.service;

import com.example.project.entity.Login;
import com.example.project.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginRepository repository;

    @Override
    public void register(Login login) throws Exception {
        repository.create(login);

    }

}

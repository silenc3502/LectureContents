package com.example.project.service;

import com.example.project.entity.Login;
import org.springframework.stereotype.Service;

public interface LoginService {
    public void register(Login login) throws Exception;
}

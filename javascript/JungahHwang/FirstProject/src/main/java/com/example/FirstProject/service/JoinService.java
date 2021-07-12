package com.example.FirstProject.service;

import com.example.FirstProject.entity.Join;

public interface JoinService {
    public void signup(Join join) throws Exception;
    public void login(Join join) throws Exception;
}

package com.example.project.service;

import com.example.project.entity.RoginMember;
import com.example.project.entity.Signup;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SignupService {
    public void register(Signup signup) throws Exception;

}

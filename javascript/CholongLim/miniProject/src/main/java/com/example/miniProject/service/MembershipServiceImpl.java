package com.example.miniProject.service;


import com.example.miniProject.entity.Membership;
import com.example.miniProject.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    private MembershipRepository repository;

    @Override
    public void register(Membership membership) throws Exception {
        repository.create(membership);
    }
}

package com.example.cholongtest.service;

import com.example.cholongtest.entity.Board;
import com.example.cholongtest.entity.Membership;
import com.example.cholongtest.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    private MembershipRepository repository;

    @Override
    public void register(Membership membership) throws Exception {
        repository.create(membership);
    }

    @Override
    public List<Membership> list() throws Exception {
        return repository.list();
    }

    @Override
    public void login(Membership membership) throws Exception {
        repository.login(membership);
    }
}

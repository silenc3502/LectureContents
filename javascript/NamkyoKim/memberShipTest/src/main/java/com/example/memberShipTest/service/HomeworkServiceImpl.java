package com.example.memberShipTest.service;


import com.example.memberShipTest.eutity.Homework;
import com.example.memberShipTest.repository.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeworkServiceImpl implements HomeworkService{
    @Autowired
    private HomeworkRepository repository;

    @Override
    public void prob66(Homework homework) throws Exception {
        repository.create(homework);
    }
}
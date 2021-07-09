package com.example.demo.service;

import com.example.demo.entity.Concert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ConcertRepository;

import java.util.List;

@Service
public class ConcertServiceImpl implements ConcertService{

    @Autowired
    private ConcertRepository repository;

    @Override
    public void register(Concert concert) {
        repository.create(concert);
    }

    @Override
    public List<Concert> list() throws Exception {
        return repository.list();
    }
}
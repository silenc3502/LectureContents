package com.example.demo.service;

import com.example.demo.entity.Concert;

import java.util.List;

public interface ConcertService {

    public void register(Concert concert);
    public List<Concert> list() throws Exception;
}
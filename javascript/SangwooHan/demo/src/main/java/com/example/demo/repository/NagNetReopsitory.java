package com.example.demo.repository;

import com.example.demo.entity.NagetloningTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NagNetReopsitory {
    @Autowired
    private JdbcTemplate jdbcTemplate2;

    public void creates(NagetloningTest nagetloningtest) throws Exception{
        String query = "insert into NagNetTest (id, address, password) values (?,?,?)";
        jdbcTemplate2.update(query,nagetloningtest.getId(), nagetloningtest.getAddress(), nagetloningtest.getPw());
    }
}

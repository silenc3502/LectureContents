package com.example.memberShipTest.repository;

import com.example.memberShipTest.eutity.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HomeworkRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Homework homework) throws Exception {
        String query = "insert into homework (id, password) values (?, ?)";

        jdbcTemplate.update(query, homework.getId(), homework.getPassword());
    }
}
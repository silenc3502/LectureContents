package com.example.wonkimproj.repository;

import com.example.wonkimproj.entity.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SignupRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(SignUp signup) throws Exception {

        String query = "insert into signUp (id, password) values (?, ?)";

        jdbcTemplate.update(query, signup.getId(), signup.getPassword());
    }
}

package com.example.personalProject2.repository;

import com.example.personalProject2.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SignUpRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create (Member member) {
        String query = "insert into member (id, pw) values (?, ?)";

        jdbcTemplate.update(query, member.getId(), member.getPw());
    }
}
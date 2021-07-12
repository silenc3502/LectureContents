package com.example.project.repository;

import com.example.project.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Login login) throws Exception{
        //(email, password, name, phoneNum)
        String query = "insert into login (email, password, name, phoneNum) values (?, ?, ?, ?)";

        jdbcTemplate.update(query, login.getEmail(), login.getPassword(), login.getName(),
                login.getPhoneNum());
    }
}

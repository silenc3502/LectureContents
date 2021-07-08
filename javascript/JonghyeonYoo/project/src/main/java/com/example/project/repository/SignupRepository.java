package com.example.project.repository;

import com.example.project.entity.Product;
import com.example.project.entity.RoginMember;
import com.example.project.entity.Signup;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class SignupRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Signup signup) throws Exception {
        String query = "insert into signup (id, password, name, phone, email, dateofbirth) values (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, signup.getId(), signup.getPassword(), signup.getName(), signup.getPhone(),
                                signup.getEmail(), signup.getDateofbirth());
    }
}


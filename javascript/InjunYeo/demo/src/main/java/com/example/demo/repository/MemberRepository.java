package com.example.demo.repository;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
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
public class MemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Member member) throws Exception{
        String query = "insert into member (id,password) values (?,?)";

        jdbcTemplate.update(query,member.getId(),member.getPassword());
    }


}

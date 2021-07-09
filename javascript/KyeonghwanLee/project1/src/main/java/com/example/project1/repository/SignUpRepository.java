package com.example.project1.repository;


import com.example.project1.entity.Member;
import com.example.project1.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
public class SignUpRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create (Member member) throws Exception {
        String query = "insert into member (id, pw, name, phoneNumber, email, address) values (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, member.getId(), member.getPw(), member.getName(), member.getPhoneNumber(), member.getEmail(), member.getAddress());
    }
    public void login(Member member) throws Exception {

        List<Member> results = jdbcTemplate.query(
                "select id, pw from member where id = ?",

                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setId(rs.getString("id"));
                        member.setPw(rs.getString("pw"));

                        return member;
                    }
                }, member.getId());

        Member tmp = results.get(0);
        log.info("tmp: " + tmp);

        if (tmp.getPw().equals(member.getPw())) {
            log.info("Password Correct");
        } else {
            log.info("Password Incorrect");
        }
    }
}
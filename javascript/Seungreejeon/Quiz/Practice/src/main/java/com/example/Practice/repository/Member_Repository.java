package com.example.Practice.repository;

import com.example.Practice.domain.Member;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.SimpleFormatter;


@Repository
public class Member_Repository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Member member) {
        String query = "insert into member (id, name, password, memberId) values (?,?,?,?)";

        jdbcTemplate.update(query, member.getId(), member.getName(), member.getPassword(), member.getMemberId());
    }

    public List<Member> lists() {
        List<Member> results = jdbcTemplate.query(
                "select id, name, password, memberId" +
                        "where product_no > order by id desc",
                new RowMapper<Member>() {
                    @SneakyThrows
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setId(rs.getInt("Id"));
                        member.setName(rs.getString("name"));
                        member.setPassword(rs.getInt("password"));
                        member.setMemberId(rs.getString("member_no"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        member.setDate(sdf.parse(rs.getDate("date") + "" + rs.getTime("date")));
                        //둘이 붙으면 오류땜에 공백
                        return member;
                    }
                }
        );
        return results;
    }
}
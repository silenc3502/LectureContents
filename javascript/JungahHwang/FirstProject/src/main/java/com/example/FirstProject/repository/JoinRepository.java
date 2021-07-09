package com.example.FirstProject.repository;

import com.example.FirstProject.entity.Join;
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
public class JoinRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Join join) throws Exception{
        String query = "insert into join_mem (id, pw, name, tel, addr, gender, email, birth) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, join.getId(),join.getPw(),join.getName(), join.getTel(),
                join.getAddr(), join.getGender(), join.getEmail(), join.getBirth());
    }
    public void login(Join join) throws Exception{
        List<Join> result = jdbcTemplate.query(
                "select id, pw from join_mem where id = ?",
                new RowMapper<Join>() {
                    @Override
                    public Join mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Join join = new Join();

                        join.setId(rs.getString("id"));
                        join.setPw(rs.getString("pw"));

                        return join;
                    }
                }, join.getId()
        );
        Join tmp = result.get(0);
        log.info("tmp: " + tmp);

        if (tmp.getPw().equals(join.getPw())){
            log.info("Password Correct");
        }else {
            log.info("Password Incorrect");
        }
    }


}

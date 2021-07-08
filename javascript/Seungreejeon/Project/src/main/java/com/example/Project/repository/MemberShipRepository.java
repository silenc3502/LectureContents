package com.example.Project.repository;


import com.example.Project.entity.Board;
import com.example.Project.entity.Membership;
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
public class MemberShipRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Membership membership) {
        String query = "insert into membership (name, password, user_id, address) values (?,?,?,?)";

        jdbcTemplate.update(query, membership.getName(), membership.getPassword(), membership.getUser_id(), membership.getAddress());
    }

    public List<Membership> list() throws Exception {
        List<Membership> results = jdbcTemplate.query(
                "select name, user_id from membership " +
                        "where membership_no > 0 order by membership_no desc",
                new RowMapper<Membership>() {
                    @Override
                    public Membership mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Membership membership = new Membership();

                        membership.setName(rs.getString("name"));
                        membership.setUser_id(rs.getString("user_id"));
                        return membership;
                    }
                }
        );
        return results;
    }
}

package com.example.miniProject.repository;


import com.example.miniProject.entity.Membership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MembershipRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Membership membership) throws Exception {
        String query = "insert into membership (memName, memID, memPassword, phoneNum, memBirth) value(?,?,?,?,?)";

        jdbcTemplate.update(query, membership.getMemName(), membership.getMemID(), membership.getMemPassword(),
                            membership.getPhoneNum(), membership.getMemBirth());
    }
}

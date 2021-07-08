package com.example.demo.repository;

import com.example.demo.entity.PurchaseMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;

@Repository
public class PurchaseMemberRepository {

    @Autowired
    private JdbcTemplate JdbcTemplate;


    public void purchasingSignUpCreate(PurchaseMember purchaseMember) throws Exception {

        String Query = "insert into purchasingMemberSignUp (id, pw, pwCheck, name, dateOfBirth, gender, phoneNumber, email, address, interest) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";



        JdbcTemplate.update(Query, purchaseMember.getId(), purchaseMember.getPw(), purchaseMember.getPwCheck(), purchaseMember.getName(),
                purchaseMember.getDateOfBirth(), purchaseMember.getGender(), purchaseMember.getPhoneNumber(),
                purchaseMember.getEmail(), purchaseMember.getAddress(), purchaseMember.getInterest());

    }

}

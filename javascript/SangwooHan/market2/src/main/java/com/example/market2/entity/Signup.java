package com.example.market2.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Signup {
    private int bulletinNo;
    private String userid;
    private String password;
    private String name;
    private int birthday;
    private String  gender;
    private Date regdate;




}

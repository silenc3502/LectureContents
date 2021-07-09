package com.example.market.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Signup {

    private String userid;
    private int password;
    private String name;
    private int birthday;
    private String  gender;
    private Date regdate;




}

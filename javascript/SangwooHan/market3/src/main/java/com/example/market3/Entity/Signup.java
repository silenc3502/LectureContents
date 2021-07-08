package com.example.market3.Entity;

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
    private String address;
    private int phoneNo;
    private Date regdate;




}

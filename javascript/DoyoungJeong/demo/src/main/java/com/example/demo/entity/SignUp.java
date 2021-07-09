package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class SignUp {

    private int memberListNo;
    private String ID;
    private String PW;
    private String name;
    private int birthMonth;
    private int birthDay;
    private String comment;
    private Date regDate;
    //ssss
}

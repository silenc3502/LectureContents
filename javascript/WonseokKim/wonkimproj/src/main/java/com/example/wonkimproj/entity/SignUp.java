package com.example.wonkimproj.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class SignUp {
    private int boardNo;
    private String id;
    private String password;
    private Date regDate;
}

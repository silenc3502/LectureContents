package com.example.market2.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Login {
    private int BulletinNo;
    private String id;
    private String pw;
    private Date regdate;

}

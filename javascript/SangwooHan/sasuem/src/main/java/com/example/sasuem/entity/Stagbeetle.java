package com.example.sasuem.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Stagbeetle {
    private int BulletinNo;
    private String username;
    private String insectname;
    private String old;
    private String habitat;
    private String description;
    private Date regdate;

}

package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString

public class Member {
    private int memberNo;
    private String id;
    private String pw;
    private String name;
    private String gender;
    private int age;
    private String location;
    private String interestedGenre;
    private String interestedArtist;
    private Date regDate;
}

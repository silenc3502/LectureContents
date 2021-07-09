package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString

public class Concert {
    private int concertNo;
    private String concertName;
    private String concertArtist;
    private String concertVenue;
    private int month;
    private int day;
    private int year;
    private int price;
    private String concertInfo;
    private String concertDate;
    private Date regDate;

}

package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
public class Board {

    private int BoardNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;


}

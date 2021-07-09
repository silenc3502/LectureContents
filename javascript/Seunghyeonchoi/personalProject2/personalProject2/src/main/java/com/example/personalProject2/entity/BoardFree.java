package com.example.personalProject2.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
public class BoardFree {

    private int boardNoFree;
    private String titleFree;
    private String contentFree;
    private String writerFree;
    private Date regDateFree;
}

package com.example.personalProject2.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
public class BoardNotice {

    private int boardNoNotice;
    private String titleNotice;
    private String contentNotice;
    private String writerNotice;
    private Date regDateNotice;
}

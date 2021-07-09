package com.example.practice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
public class Product {

    private int productNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
}


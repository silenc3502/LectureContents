package com.example.Exam.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Usermarket {
    private Date reg_date;
    private String name;
    private String productname;
    private int price;
    private String description;
    private int productno;
}

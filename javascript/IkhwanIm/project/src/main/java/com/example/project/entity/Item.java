package com.example.project.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Item {
    private int itemNo;
    private String name;
    private int price;
    private String seller;
    private Date regDate;
}

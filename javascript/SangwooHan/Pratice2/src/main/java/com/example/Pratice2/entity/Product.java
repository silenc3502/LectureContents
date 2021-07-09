package com.example.Pratice2.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Product {
    private String username;
    private int productNo;
    private String name;
    private int price;
    private String description;
    private Date regDate;
}
